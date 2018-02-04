package com.woniuxy.spring.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

	public void save() {
		// getName()获取全限定名，getSimpleName获取类名
		System.out.println(this.getClass().getName() + "save");
	}
}
