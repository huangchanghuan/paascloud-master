package com.paascloud.provider.mapper;

import com.paascloud.provider.model.domain.MqMessageData;

public interface MqMessageDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_mq_message_data
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_mq_message_data
     *
     * @mbg.generated
     */
    int insert(MqMessageData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_mq_message_data
     *
     * @mbg.generated
     */
    int insertSelective(MqMessageData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_mq_message_data
     *
     * @mbg.generated
     */
    MqMessageData selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_mq_message_data
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MqMessageData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_mq_message_data
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(MqMessageData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pc_mq_message_data
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MqMessageData record);
}