package com.woniuxy.spring.service;


import com.woniuxy.spring.entity.User;

public interface UserService extends BaseService<User> {
	/**
	 * ��֤�û���¼
	 * 
	 * @param userName
	 * @param userPass
	 */
	User validateUserInfo(String user_name, String user_pass);
	
}
