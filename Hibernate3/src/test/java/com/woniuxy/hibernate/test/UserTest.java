package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.User;

public class UserTest {
	@Test
	public void save() {
		// 创建实体管理器工厂
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		//创建实体管理器对象
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// 开启事务
		createEntityManager.getTransaction().begin();
		// 添加用户信息
		User user = new User();
		user.setName("李四");
		user.setSex("男");
		// 调用实体管理器对象的persist方法或者merge方法把数据保存到数据库中。
		createEntityManager.persist(user);
		// 提交事务
		createEntityManager.getTransaction().commit();
		// 关闭实体对象，释放资源
		createEntityManager.close();

	}
}
