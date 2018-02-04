package com.woniuxy.hibernate_2.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.woniuxy.hibernate_2.dao.po.Users;

public class userTest {

	EntityManager entityManager;

	@Before
	public void before() {
		// ����ʵ�幤��
		EntityManagerFactory createEntityManagerFactory = Persistence
				.createEntityManagerFactory("jpa");
		// ʵ������� ----->session����
		entityManager = createEntityManagerFactory.createEntityManager();
	}

	@After
	public void after() {
		// �ر���Դ
		entityManager.close();
	}

	@Test
	/**
	 * ����û�
	 */
	public void save() {
		// ��������
		entityManager.getTransaction().begin();
		// ʵ�����ݵĳ־û�
		Users user = new Users();
		user.setName("����");
		user.setPassword("ww123");
		user.setAddress("����");
		user.setAge(25);
		// ������洢 ���ݿ��У����Һ�entityManager�й������־�̬������
		entityManager.persist(user);
		// �ύ����
		entityManager.getTransaction().commit();
	}

	@Test
	public void delete() {
		// ��������
		entityManager.getTransaction().begin();
		// ��ѯ�����ݣ�����entityManager����������
		Users user = entityManager.find(Users.class, 1);
		// ������洢 ���ݿ��У����Һ�entityManager�й������־�̬������
		entityManager.remove(user);
		// �ύ����
		entityManager.getTransaction().commit();
	}

	@Test
	/**
	 * �����û�
	 */
	public void update() {
		// ��������
		entityManager.getTransaction().begin();
		// �޸Ķ���
		Users user = entityManager.find(Users.class, 2);
		user.setAddress("�ɶ�");
		// �ύ����
		entityManager.getTransaction().commit();
	}

	@Test
	/**
	 * �ҵ��û�
	 */
	public void find() {
		Users user = entityManager.find(Users.class, 2);
		System.out.println(user.getName());
	}

	/**
	 * ���β�ѯ
	 */
	@Test
	public void reference() {
		// ���ش������
		Users user = entityManager.getReference(Users.class, 2);
		// ��ʼ���������
		Hibernate.initialize(user);
		System.out.println(user.getName());
	}

}
