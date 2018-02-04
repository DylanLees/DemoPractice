package com.woniuxy.hibernate.test1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.woniuxy.hibernate.test.User;

public class UserTest {
	@Test
 public void save(){
		//1.加载hibernate的配置文件
		Configuration configuration=new Configuration().configure();
		//2.得到Session的工厂
		SessionFactory sessionFactory =configuration.buildSessionFactory();
		//3.得到Session
		Session session =sessionFactory.openSession();
		//4.得到事务
		Transaction tx=session.beginTransaction();
		//完成数据持久化
		User user=new User();
		user.setUsername("大宝");
		user.setUserpass("123");
		user.setAge(20);
		session.save(user);
		//5.提交事务
		tx.commit();
		//6.释放资源
		session.close();
		sessionFactory.close();
	}
}
