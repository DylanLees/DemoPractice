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
	 * �����û����ݵ����ݿ����
	 */
	@Test
	public void insert() {
		User user = new User();
		user.setUser_pass(DigestUtils.md5DigestAsHex("ls123".getBytes()));
		user.setUser_name("����");
		this.userService.insert(user);
	}

	/**
	 * ���û���¼��Ϣ����֤
	 */
	@Test
	public void validateUserInfo() {
		// �����û���¼��֤�߼��ķ���
		User user = this.userService.validateUserInfo("admin", "admin");
		System.err.println(user.getUser_name());
		System.err.println("�û���¼�ɹ�");

	}
}
