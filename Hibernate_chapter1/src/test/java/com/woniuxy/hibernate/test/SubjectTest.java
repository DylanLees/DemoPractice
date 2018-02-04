package com.woniuxy.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Students;
import com.woniuxy.hibernate.entity.Subjects;

public class SubjectTest {
	// 获取实体管理工厂
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	// 获取实体管理器
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Test
	public void save() {
		// 开启事务
		entityManager.getTransaction().begin();
		// 保存学生
		// Students student=entityManager.find(Students.class, 10);
		Students student = new Students();
		student.setName("老板");
		// 为学生选择课程
		Set<Subjects> subs = new HashSet<Subjects>();
		Subjects subject = new Subjects();
		subject.setSub_name("hibernate");
		subs.add(subject);
		subject = new Subjects();
		subject.setSub_name("spring");
		subs.add(subject);
		student.setSubjects(subs);
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
