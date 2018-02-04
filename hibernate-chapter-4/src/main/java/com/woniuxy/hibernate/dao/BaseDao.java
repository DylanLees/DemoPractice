package com.woniuxy.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	/**
	 * ���
	 * @param t
	 */
	void persist(T t);
	
	/**
	 * ����
	 * @param t
	 */
	void update(T t);
	
	/**
	 * ɾ��
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * ��ѯ����
	 * @param id
	 * @return
	 */
	T find(Serializable id);
	
	/**
	 * ��ѯ����
	 * @param id
	 * @return
	 */
	T referece(Serializable id);
	
	/**
	 * ͨ��jpql���в�ѯ
	 * @param jpql
	 * @param objects	�ɱ������ֻ�ܳ����ڲ����б�����һ����...��ʾ�ɱ����
	 * @return
	 */
	List<T> findByJpql(String jpql,Object...objects);
	
	/**
	 * ִ�и���
	 * @param jpql
	 * @param objects
	 * @return
	 */
	int executeUpdateByJpql(String jpql,Object...objects);
	
}
