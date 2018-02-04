package com.woniuxy.spring.service;

import java.io.Serializable;
import java.util.List;

import tk.mybatis.mapper.entity.Example;

public interface BaseService<T> {
	int insert(T t);

	int update(T t);

	int delete(T t);

	int deleteById(Serializable id);

	T findById(Serializable id);

	List<T> findByExample(Example example);

	List<T> findByEntity(T t);

}
