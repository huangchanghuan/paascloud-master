/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：HandleSendingMessageJob.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.paascloud.provider.job.dataflow;

import com.google.common.collect.Lists;
import com.paascloud.DateUtil;
import com.paascloud.elastic.lite.JobParameter;
import com.paascloud.elastic.lite.annotation.ElasticJobConfig;
import com.paascloud.elastic.lite.job.AbstractBaseDataflowJob;
import com.paascloud.provider.mapper.TpcMqConfirmMapper;
import com.paascloud.provider.model.domain.TpcMqMessage;
import com.paascloud.provider.model.dto.MessageTaskQueryDto;
import com.paascloud.provider.model.enums.JobTaskStatusEnum;
import com.paascloud.provider.model.enums.MqSendStatusEnum;
import com.paascloud.provider.service.TpcMqMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 处理发送中的消息数据.
 *
 * @author paascloud.net @gmail.com
 */
@Component
@Slf4j
@ElasticJobConfig(cron = "0/30 * * * * ?", jobParameter = "fetchNum=200")
public class HandleSendingMessageJob extends AbstractBaseDataflowJob<TpcMqMessage> {
	@Resource
	private TpcMqMessageService tpcMqMessageService;
	@Value("${paascloud.message.handleTimeout}")
	private int timeOutMinute;
	@Value("${paascloud.message.maxSendTimes}")
	private int messageMaxSendTimes;
	//重发时间间隔系数，默认是一分钟 * 系数
	@Value("${paascloud.message.resendMultiplier}")
	private int messageResendMultiplier;
	@Resource
	private TpcMqConfirmMapper tpcMqConfirmMapper;

	/**
	 * Fetch job data list.
	 *
	 * @param jobParameter the job parameter
	 *
	 * @return the list
	 */
	@Override
	protected List<TpcMqMessage> fetchJobData(JobParameter jobParameter) {
		MessageTaskQueryDto query = new MessageTaskQueryDto();
		query.setCreateTimeBefore(DateUtil.getBeforeTime(timeOutMinute));
		query.setMessageStatus(MqSendStatusEnum.SENDING.sendStatus());
		query.setFetchNum(jobParameter.getFetchNum());
		query.setShardingItem(jobParameter.getShardingItem());
		query.setShardingTotalCount(jobParameter.getShardingTotalCount());
		query.setTaskStatus(JobTaskStatusEnum.TASK_CREATE.status());
		//    AND message.task_status = #{taskStatus} 创建任务数据， 这里是不是可以放宽限制，因为elestic job是分片，所以之前处理异常时候，这里是TASK_EXETING(2, "正在处理中"),所以也适合查出来处理
		//    AND message.message_status = #{messageStatus}  已发送20
		//    AND message.created_time &lt; #{createTimeBefore} 多少时间前创建的（超时时间内没完成的消息，配置5分钟）
		//    AND message.yn = 0 未删除的
		//    ORDER BY update_time 最旧的数据排前面，之前处理过的排在后面（根据这个字段计算是否满足间隔时间重发）
		//    LIMIT ${fetchNum} 每次处理查询数量
		return tpcMqMessageService.listMessageForWaitingProcess(query);
	}

	/**
	 * Process job data.
	 *
	 * @param taskList the task list
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	protected void processJobData(List<TpcMqMessage> taskList) {
		for (TpcMqMessage message : taskList) {

			Integer resendTimes = message.getResendTimes();
			if (resendTimes >= messageMaxSendTimes) {
				//超过重发次数,设置dead 1-死亡，task_status=4，处理失败 ， 需要人工处理了
				tpcMqMessageService.setMessageToAlreadyDead(message.getId());
				continue;
			}
			//todo 为什么要系数， 新的times
			int times = (resendTimes == 0 ? 1 : resendTimes) * messageResendMultiplier;
			//当前时间，毫秒
			long currentTimeInMillis = Calendar.getInstance().getTimeInMillis();
			//第一次的的时间，毫秒， 每次是60秒重发一次
			long needTime = currentTimeInMillis - times * 60 * 1000;
			//消息的更新时间
			long hasTime = message.getUpdateTime().getTime();
			// 判断是否达到了可以再次发送的时间条件
			if (hasTime > needTime) {
				log.debug("currentTime[" + com.xiaoleilu.hutool.date.DateUtil.formatDateTime(new Date()) + "],[SENDING]消息上次发送时间[" + com.xiaoleilu.hutool.date.DateUtil.formatDateTime(message.getUpdateTime()) + "],必须过了[" + times + "]分钟才可以再发送。");
				continue;
			}

			// 前置状态
			List<Integer> preStatusList = Lists.newArrayList(JobTaskStatusEnum.TASK_CREATE.status());
			// 设置任务状态为执行中
			message.setPreStatusList(preStatusList);
			message.setTaskStatus(JobTaskStatusEnum.TASK_EXETING.status());
			int updateRes = tpcMqMessageService.updateMqMessageTaskStatus(message);
			//更新状态成功
			if (updateRes > 0) {
				try {

					// 查询是否全部订阅者都确认了消息 是 则更新消息状态完成, 否则重发消息

					int count = tpcMqConfirmMapper.selectUnConsumedCount(message.getMessageKey());
					int status = JobTaskStatusEnum.TASK_CREATE.status();
					if (count < 1) {
						//消费者确认了消费，tpc_mq_confirm状态为30
						//更新tpc_mq_message表状态为30
						TpcMqMessage update = new TpcMqMessage();
						update.setMessageStatus(MqSendStatusEnum.FINISH.sendStatus());
						update.setId(message.getId());
						tpcMqMessageService.updateMqMessageStatus(update);
						status = JobTaskStatusEnum.TASK_SUCCESS.status();
					} else {
						//消费者还没有确认消费，重发消息
						tpcMqMessageService.resendMessageByMessageId(message.getId());
					}

					// 前置状态
					preStatusList = Lists.newArrayList(JobTaskStatusEnum.TASK_EXETING.status());
					// 设置任务状态为执行中
					message.setPreStatusList(preStatusList);
					message.setTaskStatus(status);
					tpcMqMessageService.updateMqMessageTaskStatus(message);
				} catch (Exception e) {
					log.error("重发失败 ex={}", e.getMessage(), e);
					// 设置任务状态为执行中
					preStatusList = Lists.newArrayList(JobTaskStatusEnum.TASK_EXETING.status());
					message.setPreStatusList(preStatusList);
					message.setTaskStatus(JobTaskStatusEnum.TASK_CREATE.status());
					tpcMqMessageService.updateMqMessageTaskStatus(message);
				}
			}
		}
	}
}
