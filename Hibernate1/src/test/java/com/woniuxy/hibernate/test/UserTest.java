package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.User;


/**
 * JPA，通过实体Entity把数据存储到数据库。
 * @author Administrator
 *
 */

public class UserTest {
	@Test
	public void save() {

		// 创建实体管理器工厂
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		// 获取实体管理器 ----->session对象
		EntityManager entityManager = createEntityManagerFactory.createEntityManager();
		// 通过entityManager对象开启事务
		entityManager.getTransaction().begin();
		// 实例化User
		User user = new User();
		user.setName("赵六");
		user.setSex("男");
		//通过持久化entityManager的持久化方法保存user对象中的数据。
		entityManager.persist(user);
		// 提交事务
		entityManager.getTransaction().commit();
		//关闭entityManager释放资源
		entityManager.close();
	}
};
 
