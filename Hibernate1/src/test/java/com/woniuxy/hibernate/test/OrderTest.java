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
		// 创建实体管理器工厂
				EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
				// 获取实体管理器 ----->session对象
				EntityManager entityManager = createEntityManagerFactory.createEntityManager();
				// 通过entityManager对象开启事务
				entityManager.getTransaction().begin();
				// 实例化User
				Order order = new Order();
				order.setName("赵六");
				order.setCreateTime(new Date());
				//通过持久化entityManager的持久化方法保存user对象中的数据。
				entityManager.persist(order);
				// 提交事务
				entityManager.getTransaction().commit();
				//关闭entityManager释放资源
				entityManager.close();
	}
}
