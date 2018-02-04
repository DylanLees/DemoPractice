package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.User;


/**
 * JPA��ͨ��ʵ��Entity�����ݴ洢�����ݿ⡣
 * @author Administrator
 *
 */

public class UserTest {
	@Test
	public void save() {

		// ����ʵ�����������
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		// ��ȡʵ������� ----->session����
		EntityManager entityManager = createEntityManagerFactory.createEntityManager();
		// ͨ��entityManager����������
		entityManager.getTransaction().begin();
		// ʵ����User
		User user = new User();
		user.setName("����");
		user.setSex("��");
		//ͨ���־û�entityManager�ĳ־û���������user�����е����ݡ�
		entityManager.persist(user);
		// �ύ����
		entityManager.getTransaction().commit();
		//�ر�entityManager�ͷ���Դ
		entityManager.close();
	}
};
 
