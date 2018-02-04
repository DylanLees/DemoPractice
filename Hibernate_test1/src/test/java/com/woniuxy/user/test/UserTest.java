package com.woniuxy.user.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.woniuxy.hibernate.entity.User;
public class UserTest {
	@Test
	public void save(){
		//加载hibernate的配置文件
		Configuration configure = new Configuration().configure();
		//得到session的工厂
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//得到session
		Session session = sessionFactory.openSession();
		//开始事务
		Transaction transaction = session.beginTransaction();
		//完成数据持久化
		User user = new User();
		user.setName("李四");
		user.setSex("男");
		session.save(user);
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
	}
}
