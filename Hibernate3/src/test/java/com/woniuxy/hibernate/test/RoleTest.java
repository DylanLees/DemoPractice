package com.woniuxy.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Role;
import com.woniuxy.hibernate.entity.User;

public class RoleTest {

	@Test
	public void save() {
		// 创建实体管理器工厂
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// 开启事务
		createEntityManager.getTransaction().begin();
		// 添加角色信息
		Role role = new Role();
		//设置角色对象的值
		role.setName("普通用户");
		role.setId(1);
		
		//创建一个集合对象
		Set<User> users=new HashSet<User>();
		User user =new User();
		user.setId(2);
		user.setName("李四");
		user.setSex("男");
		users.add(user);
		role.setUsers(users);
		createEntityManager.merge(role);
		// 提交事务
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		createEntityManagerFactory.close();

	}
}
