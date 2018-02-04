package com.woniuxy.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.woniuxy.hibernate.entity.User;

public class UserTest {
	@Test
	public void save() {
		// 加载配置文件
		Configuration configure = new Configuration().configure();
		// 获取会话工厂
		SessionFactory sessionFactory = configure.buildSessionFactory();
		// 获取session会话
		Session session = sessionFactory.openSession();
		// 开启事务
		Transaction transaction = session.beginTransaction();
		User user = new User();
		user.setUserName("李四");
		user.setAge(25);
		//保存对象到session中
		session.save(user);
		// 释放资源
		transaction.commit();
		session.close();
	}
	

}
