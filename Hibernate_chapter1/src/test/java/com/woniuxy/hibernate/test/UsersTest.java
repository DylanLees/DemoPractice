package com.woniuxy.hibernate.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.woniuxy.hibernate.entity.Users;

public class UsersTest {
	// ��ȡʵ�������
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	// ��ȡʵ�������
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Test
	public void save() {
		// ��������
		entityManager.getTransaction().begin();
		Users users = new Users();
		users.setUserName("����");
		users.setUserPass("123456");
		entityManager.merge(users);
		// �ύ����
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
	}

	@Test
	public void find() {
		// ����id��ѯʵ�������Ϣ
		Users users = entityManager.find(Users.class, 4);
		System.err.println(users.getUserName());
	}

	/**
	 * ɾ������Ϣ
	 * 
	 */
	@Test
	public void delete() {
		// ��������
		entityManager.getTransaction().begin();
		// ����id��ѯ��Ϣ
		Users users = entityManager.find(Users.class, 1);
		// ɾ���û���Ϣ
		entityManager.remove(users);
		// �ύ����
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
	}

	/**
	 * �����û���Ϣ
	 */
	@Test
	public void update() {
		// ��������
		entityManager.getTransaction().begin();
		// �����û���Ϣ
		Users users = new Users();
		users.setUserName("����");
		users.setUserPass("123");
		entityManager.merge(users);
		entityManager.getTransaction().commit();
		entityManagerFactory.close();

	}

	/**
	 * ͨ��hql��ѯ���ݿ��û���Ϣ
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void query() {
		// ����hql���
		String hql = "from Users";
		// ��ȡ��ѯ����
		Query query = entityManager.createQuery(hql);
		// ִ�в�ѯ���󷵻�һ�������
		List<Users> list = query.getResultList();
		// ��������
		for (Users users : list) {
			System.err.println(users.getUserName());
		}

	}

	@Test
	public void query1() {
		// ����hql���
		String hql = "select count(1) from Users";
		// ��ȡ��ѯ����
		Query query = entityManager.createQuery(hql);
		Object result = query.getSingleResult();
		// ������ǿתΪLong��
		Long res = (Long) result;
		System.err.println(res);

	}

	@Test
	public void query2() {
		// ����hql���
		// String hql="from Users where id=?";
		// String hql = "from Users where id=:Uid";//���������ķ���
		String hql = "from Users where userName=:UN and userPass=:UP";
		// ��ȡquery����
		Query query = entityManager.createQuery(hql);
		// �󶨲���ֵ
		// query.setParameter(0, 2);
		// query.setParameter("Uid", 2);
		query.setParameter("UN", "����");
		query.setParameter("UP", "123456");
		// ִ��hql
		// Object object = query.getSingleResult();
		@SuppressWarnings("unchecked")
		List<Users> resultList = query.getResultList();
		// Users users = (Users) object;
		for (int i = 0; i < resultList.size(); i++) {
			System.err.println(resultList.get(i).getUserName());
		}
		// �ͷ���Դ
		entityManager.close();
		entityManagerFactory.close();

	}

	@Test
	public void query3() {
		// ׼��jpql���
		// String jpql = "select userName from Users";//��ȡ��������
		String jpql = "select userName,userPass from Users";// ��ȡ��������
		// ��ȡquery����
		Query query = entityManager.createQuery(jpql);
		// ִ��jpql
		// List<String> list = query.getResultList();
		// for (int i = 0; i < list.size(); i++) {
		// System.err.println(list.get(i));
		// }
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();
		for (Object[] object : list) {
			for (Object object2 : object) {
				System.err.println(object2);
			}
		}
		// �ͷ���Դ
		entityManager.close();
		entityManagerFactory.close();

	}
	@Test
	public void pagination(){
		//��ȡ�ܵ�����
		String jpql="select count(1) from Users";
		
		
		
		
	}

}
