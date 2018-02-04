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
		// ����ʵ�����������
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// ��������
		createEntityManager.getTransaction().begin();
		// ���ѧ����Ϣ
		Student student = new Student();
		student.setName("����");
		student.setSex("��");
		// ָ����ʦ��������ʦ��Ϣ
		Teacher teacher = new Teacher();
		teacher.setName("����ʦ");
		student.setTeacher(teacher);
		createEntityManager.merge(student);
		//�ύ����
		createEntityManager.getTransaction().commit();
		// �ͷ���Դ
		createEntityManagerFactory.close();
		createEntityManager.close();

	}

}
