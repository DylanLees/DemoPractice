package com.woniuxy.hibernate.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Users;

public class UsersTest {
	// 获取实体管理工厂
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	// 获取实体管理器
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Test
	public void save() {
		// 开启事务
		entityManager.getTransaction().begin();
		Users users = new Users();
		users.setUserName("王五");
		users.setUserPass("123456");
		entityManager.merge(users);
		// 提交事务
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
	}

	@Test
	public void find() {
		// 根据id查询实体类的信息
		Users users = entityManager.find(Users.class, 4);
		System.err.println(users.getUserName());
	}

	/**
	 * 删除表信息
	 * 
	 */
	@Test
	public void delete() {
		// 开启事务
		entityManager.getTransaction().begin();
		// 根据id查询信息
		Users users = entityManager.find(Users.class, 1);
		// 删除用户信息
		entityManager.remove(users);
		// 提交事务
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
	}

	/**
	 * 更新用户信息
	 */
	@Test
	public void update() {
		// 开启事务
		entityManager.getTransaction().begin();
		// 更新用户信息
		Users users = new Users();
		users.setUserName("王九");
		users.setUserPass("123");
		entityManager.merge(users);
		entityManager.getTransaction().commit();
		entityManagerFactory.close();

	}

	/**
	 * 通过hql查询数据库用户信息
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void query() {
		// 定义hql语句
		String hql = "from Users";
		// 获取查询对象
		Query query = entityManager.createQuery(hql);
		// 执行查询对象返回一个结果集
		List<Users> list = query.getResultList();
		// 遍历集合
		for (Users users : list) {
			System.err.println(users.getUserName());
		}

	}

	@Test
	public void query1() {
		// 创建hql语句
		String hql = "select count(1) from Users";
		// 获取查询对象
		Query query = entityManager.createQuery(hql);
		Object result = query.getSingleResult();
		// 将对象强转为Long型
		Long res = (Long) result;
		System.err.println(res);

	}

	@Test
	public void query2() {
		// 创建hql语句
		// String hql="from Users where id=?";
		// String hql = "from Users where id=:Uid";//参数命名的方法
		String hql = "from Users where userName=:UN and userPass=:UP";
		// 获取query对象
		Query query = entityManager.createQuery(hql);
		// 绑定参数值
		// query.setParameter(0, 2);
		// query.setParameter("Uid", 2);
		query.setParameter("UN", "王五");
		query.setParameter("UP", "123456");
		// 执行hql
		// Object object = query.getSingleResult();
		@SuppressWarnings("unchecked")
		List<Users> resultList = query.getResultList();
		// Users users = (Users) object;
		for (int i = 0; i < resultList.size(); i++) {
			System.err.println(resultList.get(i).getUserName());
		}
		// 释放资源
		entityManager.close();
		entityManagerFactory.close();

	}

	@Test
	public void query3() {
		// 准备jpql语句
		// String jpql = "select userName from Users";//获取单行数据
		String jpql = "select userName,userPass from Users";// 获取多行数据
		// 获取query对象
		Query query = entityManager.createQuery(jpql);
		// 执行jpql
		// List<String> list = query.getResultList();
		// for (int i = 0; i < list.size(); i++) {
		// System.err.println(list.get(i));
		// }
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();
		for (Object[] object : list) {
			for (Object object2 : object) {
				System.err.println(object2);
			}
		}
		// 释放资源
		entityManager.close();
		entityManagerFactory.close();

	}
	@Test
	public void pagination(){
		//获取总的行数
		String jpql="select count(1) from Users";
		
		
		
		
	}

}
