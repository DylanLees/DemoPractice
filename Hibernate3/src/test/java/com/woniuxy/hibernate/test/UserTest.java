package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.User;

public class UserTest {
	@Test
	public void save() {
		// ����ʵ�����������
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		//����ʵ�����������
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// ��������
		createEntityManager.getTransaction().begin();
		// ����û���Ϣ
		User user = new User();
		user.setName("����");
		user.setSex("��");
		// ����ʵ������������persist��������merge���������ݱ��浽���ݿ��С�
		createEntityManager.persist(user);
		// �ύ����
		createEntityManager.getTransaction().commit();
		// �ر�ʵ������ͷ���Դ
		createEntityManager.close();

	}
}
