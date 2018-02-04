package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Student;
import com.woniuxy.hibernate.entity.Teacher;

public class StudentTest {

	@Test
	public void save() {
		// 创建实体管理器工厂
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// 开启事务
		createEntityManager.getTransaction().begin();
		// 添加学生信息
		Student student = new Student();
		student.setName("张三");
		student.setSex("男");
		// 指定老师并保存老师信息
		Teacher teacher = new Teacher();
		teacher.setName("张老师");
		student.setTeacher(teacher);
		createEntityManager.merge(student);
		//提交事务
		createEntityManager.getTransaction().commit();
		// 释放资源
		createEntityManagerFactory.close();
		createEntityManager.close();

	}

}
