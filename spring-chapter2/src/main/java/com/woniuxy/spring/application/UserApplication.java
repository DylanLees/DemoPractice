package com.woniuxy.spring.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.woniuxy.spring.controller.UserController;
import com.woniuxy.spring.service.UserService;

@Configuration
public class UserApplication {
	@Bean
	public UserController userController() {
		UserController userController = new UserController();
		userController.setUserService(userService());
		return userController;
	}

	@Bean
	public UserService userService() {

		return new UserService();
	}

}
