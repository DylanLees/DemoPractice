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
	// ��ȡʵ�������
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	// ��ȡʵ�������
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Test
	public void save() {
		// ��������
		entityManager.getTransaction().begin();
		// ����ѧ��
		// Students student=entityManager.find(Students.class, 10);
		Students student = new Students();
		student.setName("�ϰ�");
		// Ϊѧ��ѡ��γ�
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
