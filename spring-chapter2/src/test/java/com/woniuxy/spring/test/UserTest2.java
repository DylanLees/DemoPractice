package com.woniuxy.spring.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woniuxy.spring.application.UserApplication2;
import com.woniuxy.spring.controller.UserController;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=UserApplication2.class)
public class UserTest2 {
	@Resource
	private UserController userController;
	@Test
	public void init(){
		userController.save();
	}
}
