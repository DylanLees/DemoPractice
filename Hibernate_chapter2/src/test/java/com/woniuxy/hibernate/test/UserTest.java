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
		// ���������ļ�
		Configuration configure = new Configuration().configure();
		// ��ȡ�Ự����
		SessionFactory sessionFactory = configure.buildSessionFactory();
		// ��ȡsession�Ự
		Session session = sessionFactory.openSession();
		// ��������
		Transaction transaction = session.beginTransaction();
		User user = new User();
		user.setUserName("����");
		user.setAge(25);
		//�������session��
		session.save(user);
		// �ͷ���Դ
		transaction.commit();
		session.close();
	}
	

}
