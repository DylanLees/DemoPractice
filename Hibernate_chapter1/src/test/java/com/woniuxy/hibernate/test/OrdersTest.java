package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Orders;

public class OrdersTest {
	// 获取实体管理工厂
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	// 获取实体管理器
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Test
	public void save() {
		// 开启事务
		entityManager.getTransaction().begin();
		Orders orders = new Orders();
		orders.setName("老li");
		orders.setAge(10);
		entityManager.persist(orders);
		// 释放资源
		entityManager.getTransaction().commit();
		entityManager.clear();
	}
	@Test
	public void find(){
		Orders orders = entityManager.find(Orders.class, "201712141556470a5e9fd8-5d33-47ab-a013-2fdcff36ba50");
//		entityManager.merge(orders);
		entityManager.close();
		System.err.println(orders.getCount());
	}
	
}
