package com.woniuxy.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Students;
import com.woniuxy.hibernate.entity.Teachers;

public class StudentsTest {
	// 获取实体管理工厂
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	// 获取实体管理器
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Test
	public void save() {
		// 开启事务
		entityManager.getTransaction().begin();
		// 保存学生信息到数据库
		Students student = new Students();
		student.setName("张三");
		student.setAddr("成都");
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Test
	public void many2One() {
		// 开启事务
		entityManager.getTransaction().begin();
		// 先保存老师的信息
		Teachers teacher = new Teachers();
		teacher.setName("张老师");
		// teacher.setId(3);// 引用数据库中已经存在的数据
		entityManager.persist(teacher);
		// 处理学生和老师的关系
		Students student = new Students();
		// student.setId(2);
		student.setName("李米");
		student.setAddr("高新");
		student.setTeacher(teacher);
		// 保存学生信息至数据库
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Test
	public void one2Many() {
		// 开启事务
		entityManager.getTransaction().begin();
		// 设置老师
		Teachers teacher = new Teachers();
		teacher.setName("张老师");

		// 创建一个用于存放学生信息的集合
		Set<Students> students = new HashSet<Students>();
		// 创建一个学生对象
		Students student = new Students();
		// student.setId(9);
		student.setName("李四");
		student.setAddr("成都");
		students.add(student);
		// 为老师分配学生
		teacher.setStudents(students);
		entityManager.persist(teacher);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Test
	public void delete() {
		// 开启事务
		entityManager.getTransaction().begin();
		Teachers teacher = entityManager.find(Teachers.class, 9);
		entityManager.remove(teacher);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
