package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class UserTest {
	@Test
      public void save(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();//开启事务
		
		User user=new User();
		user.setAge(20);
		user.setUsername("二宝");
		user.setUserpass("123");
		entityManager.persist(user);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	@Test
	public void Update(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();//开启事务
		
		User user=new User();
		user.setUsername("四宝");
		
	}
}
