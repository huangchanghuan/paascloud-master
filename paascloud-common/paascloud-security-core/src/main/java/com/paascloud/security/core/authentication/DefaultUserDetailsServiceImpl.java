package com.paascloud.security.core.authentication;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

/**
 * 默认的 UserDetailsService 实现
 * 不做任何处理，只在控制台打印一句日志，然后抛出异常，提醒业务系统自己配置 UserDetailsService。
 *
 * @author paascloud.net @gmail.com
 */
@Slf4j
@Data
public class DefaultUserDetailsServiceImpl implements UserDetailsService {

	private UserDetailsService userDetailsService;
	/**
	 * Load user by username user details.
	 *
	 * @param username the username
	 *
	 * @return the user details
	 *
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("请配置 UserDetailsService 接口的实现.");
//		throw new UsernameNotFoundException(username);
		return userDetailsService.loadUserByUsername(username);
	}

}
