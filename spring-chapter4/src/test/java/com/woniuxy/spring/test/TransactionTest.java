package com.woniuxy.spring.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woniuxy.spring.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class TransactionTest {
	@Resource
	private UserDao userDao;

	@Test
	public void save()throws Exception {
		userDao.save();

	}
	@Test
	public void update() throws Exception{
		userDao.update();
	}
}
