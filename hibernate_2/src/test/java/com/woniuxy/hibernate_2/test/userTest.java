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
		// 创建实体工厂
		EntityManagerFactory createEntityManagerFactory = Persistence
				.createEntityManagerFactory("jpa");
		// 实体管理器 ----->session对象
		entityManager = createEntityManagerFactory.createEntityManager();
	}

	@After
	public void after() {
		// 关闭资源
		entityManager.close();
	}

	@Test
	/**
	 * 添加用户
	 */
	public void save() {
		// 开启事物
		entityManager.getTransaction().begin();
		// 实现数据的持久化
		Users user = new Users();
		user.setName("王五");
		user.setPassword("ww123");
		user.setAddress("绵阳");
		user.setAge(25);
		// 将对象存储 数据库中，并且和entityManager有关联，持久态的数据
		entityManager.persist(user);
		// 提交事务
		entityManager.getTransaction().commit();
	}

	@Test
	public void delete() {
		// 开启事物
		entityManager.getTransaction().begin();
		// 查询出数据，交由entityManager管理器管理
		Users user = entityManager.find(Users.class, 1);
		// 将对象存储 数据库中，并且和entityManager有关联，持久态的数据
		entityManager.remove(user);
		// 提交事务
		entityManager.getTransaction().commit();
	}

	@Test
	/**
	 * 更新用户
	 */
	public void update() {
		// 开启事物
		entityManager.getTransaction().begin();
		// 修改对象
		Users user = entityManager.find(Users.class, 2);
		user.setAddress("成都");
		// 提交事务
		entityManager.getTransaction().commit();
	}

	@Test
	/**
	 * 找到用户
	 */
	public void find() {
		Users user = entityManager.find(Users.class, 2);
		System.out.println(user.getName());
	}

	/**
	 * 二次查询
	 */
	@Test
	public void reference() {
		// 返回代理对象
		Users user = entityManager.getReference(Users.class, 2);
		// 初始化代理对象
		Hibernate.initialize(user);
		System.out.println(user.getName());
	}

}
