package com.woniuxy.spring.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.spring.service.BaseService;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

@Transactional(readOnly = true) // 事务管理机制为只读
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	private Mapper<T> mapper;

	public void setMapper(Mapper<T> mapper) {
		this.mapper = mapper;
	}

	/**
	 * 插入用户信息
	 */
	@Override
	public int insert(T t) {

		return mapper.insert(t);
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public int update(T t) {

		return mapper.updateByPrimaryKey(t);
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public int delete(T t) {

		return mapper.delete(t);
	}

	/**
	 * 通过用户id删除用户信息
	 */
	@Override
	public int deleteById(Serializable id) {

		return mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 通过id查询用户信息
	 */
	@Override
	public T findById(Serializable id) {

		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询用户信息
	 */
	@Override
	public List<T> findByExample(Example example) {

		return mapper.selectByExample(example);
	}

	/**
	 * 通过对象实体对象查询用户信息
	 */
	@Override
	public List<T> findByEntity(T t) {

		return this.mapper.select(t);
	}

}
