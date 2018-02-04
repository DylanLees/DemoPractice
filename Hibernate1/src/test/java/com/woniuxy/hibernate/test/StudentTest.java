package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Student;


public class StudentTest {
	@Test
	public void save(){
		// 创建实体管理器工厂
				EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
				// 获取实体管理器 ----->session对象
				EntityManager entityManager = createEntityManagerFactory.createEntityManager();
				// 通过entityManager对象开启事务
				entityManager.getTransaction().begin();
				// 实例化User
				Student student = new Student();
				student.setName("赵六");
				student.setAddress("成都");
				//通过持久化entityManager的持久化方法保存user对象中的数据。
				entityManager.persist(student);
				// 提交事务
				entityManager.getTransaction().commit();
				//关闭entityManager释放资源
				entityManager.close();
	}
}
