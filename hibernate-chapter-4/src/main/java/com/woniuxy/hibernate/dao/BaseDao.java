package com.woniuxy.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	/**
	 * 添加
	 * @param t
	 */
	void persist(T t);
	
	/**
	 * 更新
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 删除
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * 查询数据
	 * @param id
	 * @return
	 */
	T find(Serializable id);
	
	/**
	 * 查询数据
	 * @param id
	 * @return
	 */
	T referece(Serializable id);
	
	/**
	 * 通过jpql进行查询
	 * @param jpql
	 * @param objects	可变参数，只能出现在参数列表的最后一个，...表示可变参数
	 * @return
	 */
	List<T> findByJpql(String jpql,Object...objects);
	
	/**
	 * 执行更新
	 * @param jpql
	 * @param objects
	 * @return
	 */
	int executeUpdateByJpql(String jpql,Object...objects);
	
}
