package com.woniuxy.spring.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.woniuxy.spring.service.UserService;
@Controller
public class UserController {
	@Resource
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void save(){
		System.out.println(this.getClass().getName()+"save");
		this.userService.save();
		
	}
}
