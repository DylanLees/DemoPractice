package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.IdCards;
import com.woniuxy.hibernate.entity.Users;

public class IdCardTest {

	// ��ȡʵ�������
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	// ��ȡʵ�������
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Test
	public void one2one() {
		// ��������
		entityManager.getTransaction().begin();
		Users user = entityManager.find(Users.class, 3);
		// ������ϵ
		IdCards idcard = new IdCards();
		idcard.setIdnum("123458798");
		idcard.setUser(user);
		entityManager.persist(idcard);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
