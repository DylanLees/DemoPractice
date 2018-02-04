package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.IdCard;
import com.woniuxy.hibernate.entity.User;

public class IdCardTest {
	@Test
	public void save(){
		// 创建实体管理器工厂
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		//创建实体管理器
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// 开启事务
		createEntityManager.getTransaction().begin();
		//添加用户信息
		IdCard idCard=new IdCard();
		User user=new User();
		idCard.setNumber("532125198706254874");
		user.setName("heheh");
		//调用实体管理器对象里面的persist方法或者merge方法存储数据到数据库中。
		createEntityManager.persist(user);
		createEntityManager.persist(idCard);
		//提交事务
		createEntityManager.getTransaction().commit();
		//关闭实体管理器，释放资源。
		createEntityManager.close();
	}
}
