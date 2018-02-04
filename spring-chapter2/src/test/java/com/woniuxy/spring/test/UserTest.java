package com.woniuxy.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.woniuxy.spring.application.UserApplication;
import com.woniuxy.spring.controller.UserController;

public class UserTest {
	@SuppressWarnings("resource")
	@Test
	public void init(){
		ApplicationContext context = new AnnotationConfigApplicationContext(UserApplication.class);
		UserController controller = context.getBean(UserController.class);
		controller.save();
	}
}
