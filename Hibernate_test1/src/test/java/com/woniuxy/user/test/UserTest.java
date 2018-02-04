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
		//����hibernate�������ļ�
		Configuration configure = new Configuration().configure();
		//�õ�session�Ĺ���
		SessionFactory sessionFactory = configure.buildSessionFactory();
		//�õ�session
		Session session = sessionFactory.openSession();
		//��ʼ����
		Transaction transaction = session.beginTransaction();
		//������ݳ־û�
		User user = new User();
		user.setName("����");
		user.setSex("��");
		session.save(user);
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
	}
}
