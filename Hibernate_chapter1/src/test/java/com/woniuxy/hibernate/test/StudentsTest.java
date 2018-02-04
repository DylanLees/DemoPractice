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
	// ��ȡʵ�������
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	// ��ȡʵ�������
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Test
	public void save() {
		// ��������
		entityManager.getTransaction().begin();
		// ����ѧ����Ϣ�����ݿ�
		Students student = new Students();
		student.setName("����");
		student.setAddr("�ɶ�");
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Test
	public void many2One() {
		// ��������
		entityManager.getTransaction().begin();
		// �ȱ�����ʦ����Ϣ
		Teachers teacher = new Teachers();
		teacher.setName("����ʦ");
		// teacher.setId(3);// �������ݿ����Ѿ����ڵ�����
		entityManager.persist(teacher);
		// ����ѧ������ʦ�Ĺ�ϵ
		Students student = new Students();
		// student.setId(2);
		student.setName("����");
		student.setAddr("����");
		student.setTeacher(teacher);
		// ����ѧ����Ϣ�����ݿ�
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Test
	public void one2Many() {
		// ��������
		entityManager.getTransaction().begin();
		// ������ʦ
		Teachers teacher = new Teachers();
		teacher.setName("����ʦ");

		// ����һ�����ڴ��ѧ����Ϣ�ļ���
		Set<Students> students = new HashSet<Students>();
		// ����һ��ѧ������
		Students student = new Students();
		// student.setId(9);
		student.setName("����");
		student.setAddr("�ɶ�");
		students.add(student);
		// Ϊ��ʦ����ѧ��
		teacher.setStudents(students);
		entityManager.persist(teacher);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Test
	public void delete() {
		// ��������
		entityManager.getTransaction().begin();
		Teachers teacher = entityManager.find(Teachers.class, 9);
		entityManager.remove(teacher);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
