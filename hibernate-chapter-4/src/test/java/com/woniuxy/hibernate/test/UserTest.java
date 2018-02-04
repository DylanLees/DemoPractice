package com.woniuxy.hibernate.test;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Student;

public class UserTest {

	@Test
	public void save(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		entityManagerFactory.close();
		
		//级联、拦截载的问题
	}
	
	@Test
	public void set(){
		Set<Student> students=new TreeSet<>();
		Student student = null;
		student.setAge(12);
		students.add(student);
		
		student=new Student();
		student.setAge(23);
		students.add(student);
		
		student=new Student();
		student.setAge(14);
		students.add(student);
		
		for (Student studen1t : students) {
			System.out.println(studen1t.getAge());
		}
	}
	
}
