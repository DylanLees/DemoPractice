package com.woniuxy.hibernate.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.woniuxy.hibernate.dao.BaseDao;
import com.woniuxy.hibernate.util.JpaUtils;

/**
 * 1. hibernate���������
 * 2. ���ͣ�ͨ���������ͣ��������� ����
 * @author ping
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T>{
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")  
	public BaseDaoImpl() {
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();//�õ����ͻ��ĸ���
		//��ȡʵ�ʵĲ�������
		this.clazz=(Class<T>) type.getActualTypeArguments()[0];
	}

	@Override
	public void persist(T t) {
		EntityManager entityManager = JpaUtils.entityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(t);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void update(T t) {
		//����ʵ�������
		EntityManager entityManager = JpaUtils.entityManagerFactory().createEntityManager();
		//��������
		entityManager.getTransaction().begin();
		//����ʵ���������merge������t��������ݿ��С�
		entityManager.merge(t);
		//�ύ����
		entityManager.getTransaction().commit();
		//�ͷ���Դ���ر�ʵ�������
		entityManager.close();
	}

	@Override
	public void delete(T t) {
		EntityManager entityManager = JpaUtils.entityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.remove(t);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public T find(Serializable id) {
		EntityManager entityManager = JpaUtils.entityManagerFactory().createEntityManager();
		
		T t = entityManager.find(clazz, id);
		
		entityManager.close();
		return t;
	}

	@Override
	public T referece(Serializable id) {
		EntityManager entityManager = JpaUtils.entityManagerFactory().createEntityManager();
		
		T t = entityManager.getReference(clazz, id);
		
		entityManager.close();
		return t;
	}

	@Override
	public List<T> findByJpql(String jpql, Object... objects) {
		EntityManager entityManager = JpaUtils.entityManagerFactory().createEntityManager();
		Query query = entityManager.createQuery(jpql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		
		@SuppressWarnings("unchecked")
		List<T> results = query.getResultList();
		
		entityManager.close();
		return results;
	}
	
	@Override
	public int executeUpdateByJpql(String jpql, Object... objects) {
		EntityManager entityManager = JpaUtils.entityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery(jpql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		
		int result = query.executeUpdate();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

}
