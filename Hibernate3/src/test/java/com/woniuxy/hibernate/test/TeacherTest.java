package com.woniuxy.hibernate.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.woniuxy.hibernate.entity.PageInfo;
import com.woniuxy.hibernate.entity.Teacher;

public class TeacherTest {

	@Test
	public void save() {
		// ����ʵ�����������
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// ��������
		createEntityManager.getTransaction().begin();
		// �����ʦ��Ϣ
		Teacher teacher = new Teacher();
		teacher.setName("����ʦ");
		teacher.setTel("13625417895");
		createEntityManager.merge(teacher);
		// �ύ����
		createEntityManager.getTransaction().commit();
		// �ͷ���Դ
		createEntityManagerFactory.close();

	}

	@Test
	public void queryById() {
		// ����ʵ�����������
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		// ����ʵ�������
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// ��������
		createEntityManager.getTransaction().begin();
		// ����jpql���
		String jpql = "from Teacher where id=:Tid";
		// ������ѯ����
		Query query = createEntityManager.createQuery(jpql);
		// ������
		query.setParameter("Tid", 1);
		// ִ�в�ѯ
		List<Teacher> teachers = query.getResultList();// ��ѯ���ص������
		// �ͷ���Դ
		createEntityManager.close();
		createEntityManagerFactory.close();
		// �����ѯ�Ľ��
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getName());
		}

	}

	@Test
	public void query1() {
		// ����ʵ�����������
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		// ����ʵ�������
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// ��������
		createEntityManager.getTransaction().begin();
		// ����jpql���
		String jpql = "from Teacher where id=?";
		// ����query����
		Query createQuery = createEntityManager.createQuery(jpql);
		// �󶨲���
		createQuery.setParameter(1, 1);
		// ִ��query
		// List<Teacher> teachers = createQuery.getResultList();//����һ�����϶���
		Teacher teachers = (Teacher) createQuery.getSingleResult();// ���ص�������
		// �ͷ���Դ
		createEntityManager.close();
		createEntityManagerFactory.close();
		System.out.println(teachers.getName());

	}
	@Test
	public void query2(){
		// ����ʵ�����������
				EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
				// ����ʵ�������
				EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
				// ��������
				createEntityManager.getTransaction().begin();
				// ����hql���
				String hql = "select count(1) from Teacher";
				//����query����
				Query createQuery = createEntityManager.createQuery(hql);
				//ִ��query
				Object singleResult = createQuery.getSingleResult();
				// �ͷ���Դ
				createEntityManager.close();
				createEntityManagerFactory.close();
				System.out.println("��ѯ������"+singleResult);
				
	}
	/**
	 * ��ҳ��ѯ
	 */
	@Test
	public void queryPage(){
		// ����ʵ�����������
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		// ����ʵ�������
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		// ��������
		createEntityManager.getTransaction().begin();
		// ��ѯ�ܵ�����
		String hql="select count(1) from Teacher";
		//��ҳ
		PageInfo<Teacher> pageInfor = new PageInfo<Teacher>();
		//����query����
		Query query = createEntityManager.createQuery(hql);
		//ִ��query,��ȡ�ܵ�����
		int totalRow=((Long)query.getSingleResult()).intValue();//���صĽ��Ϊһ��Long��
		pageInfor.setTotalRow(totalRow);
		//��ҳ��ѯ
		String hql1="from Teacher";
		//����query����
		 Query createQuery = createEntityManager.createQuery(hql);
		// �ͷ���Դ
		createEntityManager.close();
		createEntityManagerFactory.close();
		
		
		
	}
	
}
