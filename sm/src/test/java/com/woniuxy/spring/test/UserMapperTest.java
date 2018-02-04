package com.woniuxy.spring.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import com.woniuxy.spring.entity.User;
import com.woniuxy.spring.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class UserMapperTest {
	@Resource
	private UserService userService;

	@Test
	public void delete() {

		this.userService.deleteById(6);

	}

	/**
	 * 插入用户数据到数据库表中
	 */
	@Test
	public void insert() {
		User user = new User();
		user.setUser_pass(DigestUtils.md5DigestAsHex("ls123".getBytes()));
		user.setUser_name("李四");
		this.userService.insert(user);
	}

	/**
	 * 在用户登录信息的验证
	 */
	@Test
	public void validateUserInfo() {
		// 调用用户登录验证逻辑的方法
		User user = this.userService.validateUserInfo("admin", "admin");
		System.err.println(user.getUser_name());
		System.err.println("用户登录成功");

	}
}
