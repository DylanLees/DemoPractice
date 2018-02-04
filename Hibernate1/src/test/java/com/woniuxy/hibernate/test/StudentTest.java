package com.woniuxy.hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Student;


public class StudentTest {
	@Test
	public void save(){
		// ����ʵ�����������
				EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
				// ��ȡʵ������� ----->session����
				EntityManager entityManager = createEntityManagerFactory.createEntityManager();
				// ͨ��entityManager����������
				entityManager.getTransaction().begin();
				// ʵ����User
				Student student = new Student();
				student.setName("����");
				student.setAddress("�ɶ�");
				//ͨ���־û�entityManager�ĳ־û���������user�����е����ݡ�
				entityManager.persist(student);
				// �ύ����
				entityManager.getTransaction().commit();
				//�ر�entityManager�ͷ���Դ
				entityManager.close();
	}
}
