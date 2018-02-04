package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Student;
import com.woniuxy.hibernate.entity.Teacher;

public class StudentTest {

	@Test
	public void save(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		//添加学生信息,分配老师--->该老师数据库中存在----->由id决定
		Student student=new Student();
		student.setName("张三1");
		
		//指定老师
		Teacher teacher=new Teacher();
		//teacher.setName("李老师");
		teacher.setId(1);//就可以唯一确定老师的信息
		//维系关系
		student.setTeacher(teacher);
		
		//1.先将老师进行保存
		//entityManager.persist(teacher);
		//2.直接分配数据库中已经存在的老师
		//3.级联
		
		entityManager.merge(student);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
