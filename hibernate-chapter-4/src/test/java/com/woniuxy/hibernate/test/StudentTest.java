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

		//���ѧ����Ϣ,������ʦ--->����ʦ���ݿ��д���----->��id����
		Student student=new Student();
		student.setName("����1");
		
		//ָ����ʦ
		Teacher teacher=new Teacher();
		//teacher.setName("����ʦ");
		teacher.setId(1);//�Ϳ���Ψһȷ����ʦ����Ϣ
		//άϵ��ϵ
		student.setTeacher(teacher);
		
		//1.�Ƚ���ʦ���б���
		//entityManager.persist(teacher);
		//2.ֱ�ӷ������ݿ����Ѿ����ڵ���ʦ
		//3.����
		
		entityManager.merge(student);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
