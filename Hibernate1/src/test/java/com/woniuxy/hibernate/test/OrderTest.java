package com.woniuxy.hibernate.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Order;

public class OrderTest {
	@Test
	public void save(){
		// ����ʵ�����������
				EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
				// ��ȡʵ������� ----->session����
				EntityManager entityManager = createEntityManagerFactory.createEntityManager();
				// ͨ��entityManager����������
				entityManager.getTransaction().begin();
				// ʵ����User
				Order order = new Order();
				order.setName("����");
				order.setCreateTime(new Date());
				//ͨ���־û�entityManager�ĳ־û���������user�����е����ݡ�
				entityManager.persist(order);
				// �ύ����
				entityManager.getTransaction().commit();
				//�ر�entityManager�ͷ���Դ
				entityManager.close();
	}
}
