package com.woniuxy.hibernate.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.woniuxy.hibernate.dao.BaseDao;
import com.woniuxy.hibernate.util.JpaUtils;

/**
 * 1. hibernate：面向对象
 * 2. 泛型，通用数据类型，限制数据 类型
 * @author ping
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T>{
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")  
	public BaseDaoImpl() {
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();//得到泛型化的父类
		//获取实际的参数类型
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
		//创建实体管理器
		EntityManager entityManager = JpaUtils.entityManagerFactory().createEntityManager();
		//开启事务
		entityManager.getTransaction().begin();
		//调用实体管理器的merge方法把t存放在数据库中。
		entityManager.merge(t);
		//提交事务
		entityManager.getTransaction().commit();
		//释放资源，关闭实体管理器
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
