package com.woniuxy.hibernate.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.woniuxy.hibernate.entity.PageInfo;
import com.woniuxy.hibernate.entity.Teacher;

public class TeacherTest {

	@Test
	public void save() {
		// 创建实体管理器工厂
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// 开启事务
		createEntityManager.getTransaction().begin();
		// 添加老师信息
		Teacher teacher = new Teacher();
		teacher.setName("张老师");
		teacher.setTel("13625417895");
		createEntityManager.merge(teacher);
		// 提交事务
		createEntityManager.getTransaction().commit();
		// 释放资源
		createEntityManagerFactory.close();

	}

	@Test
	public void queryById() {
		// 创建实体管理器工厂
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		// 创建实体管理器
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// 开启事务
		createEntityManager.getTransaction().begin();
		// 创建jpql语句
		String jpql = "from Teacher where id=:Tid";
		// 创建查询对象
		Query query = createEntityManager.createQuery(jpql);
		// 绑定数据
		query.setParameter("Tid", 1);
		// 执行查询
		List<Teacher> teachers = query.getResultList();// 查询返回单个结果
		// 释放资源
		createEntityManager.close();
		createEntityManagerFactory.close();
		// 输出查询的结果
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getName());
		}

	}

	@Test
	public void query1() {
		// 创建实体管理器工厂
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		// 创建实体管理器
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// 开启事务
		createEntityManager.getTransaction().begin();
		// 创建jpql语句
		String jpql = "from Teacher where id=?";
		// 创建query对象
		Query createQuery = createEntityManager.createQuery(jpql);
		// 绑定参数
		createQuery.setParameter(1, 1);
		// 执行query
		// List<Teacher> teachers = createQuery.getResultList();//返回一个集合对象
		Teacher teachers = (Teacher) createQuery.getSingleResult();// 返回单个对象
		// 释放资源
		createEntityManager.close();
		createEntityManagerFactory.close();
		System.out.println(teachers.getName());

	}
	@Test
	public void query2(){
		// 创建实体管理器工厂
				EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
				// 创建实体管理器
				EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
				// 开启事务
				createEntityManager.getTransaction().begin();
				// 创建hql语句
				String hql = "select count(1) from Teacher";
				//创建query对象
				Query createQuery = createEntityManager.createQuery(hql);
				//执行query
				Object singleResult = createQuery.getSingleResult();
				// 释放资源
				createEntityManager.close();
				createEntityManagerFactory.close();
				System.out.println("查询行数："+singleResult);
				
	}
	/**
	 * 分页查询
	 */
	@Test
	public void queryPage(){
		// 创建实体管理器工厂
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		// 创建实体管理器
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// 开启事务
		createEntityManager.getTransaction().begin();
		// 查询总的行数
		String hql="select count(1) from Teacher";
		//分页
		PageInfo<Teacher> pageInfor = new PageInfo<Teacher>();
		//创建query对象
		Query query = createEntityManager.createQuery(hql);
		//执行query,获取总的行数
		int totalRow=((Long)query.getSingleResult()).intValue();//返回的结果为一个Long型
		pageInfor.setTotalRow(totalRow);
		//分页查询
		String hql1="from Teacher";
		//创建query对象
		 Query createQuery = createEntityManager.createQuery(hql);
		// 释放资源
		createEntityManager.close();
		createEntityManagerFactory.close();
		
		
		
	}
	
}
