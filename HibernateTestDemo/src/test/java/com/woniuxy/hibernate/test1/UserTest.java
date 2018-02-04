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
		//1.����hibernate�������ļ�
		Configuration configuration=new Configuration().configure();
		//2.�õ�Session�Ĺ���
		SessionFactory sessionFactory =configuration.buildSessionFactory();
		//3.�õ�Session
		Session session =sessionFactory.openSession();
		//4.�õ�����
		Transaction tx=session.beginTransaction();
		//������ݳ־û�
		User user=new User();
		user.setUsername("��");
		user.setUserpass("123");
		user.setAge(20);
		session.save(user);
		//5.�ύ����
		tx.commit();
		//6.�ͷ���Դ
		session.close();
		sessionFactory.close();
	}
}
