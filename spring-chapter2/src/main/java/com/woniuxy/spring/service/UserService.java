package com.woniuxy.spring.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

	public void save() {
		// getName()��ȡȫ�޶�����getSimpleName��ȡ����
		System.out.println(this.getClass().getName() + "save");
	}
}
