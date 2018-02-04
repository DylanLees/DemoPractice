package com.woniuxy.spring.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.spring.service.BaseService;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

@Transactional(readOnly = true) // ����������Ϊֻ��
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	private Mapper<T> mapper;

	public void setMapper(Mapper<T> mapper) {
		this.mapper = mapper;
	}

	/**
	 * �����û���Ϣ
	 */
	@Override
	public int insert(T t) {

		return mapper.insert(t);
	}

	/**
	 * �����û���Ϣ
	 */
	@Override
	public int update(T t) {

		return mapper.updateByPrimaryKey(t);
	}

	/**
	 * ɾ���û���Ϣ
	 */
	@Override
	public int delete(T t) {

		return mapper.delete(t);
	}

	/**
	 * ͨ���û�idɾ���û���Ϣ
	 */
	@Override
	public int deleteById(Serializable id) {

		return mapper.deleteByPrimaryKey(id);
	}

	/**
	 * ͨ��id��ѯ�û���Ϣ
	 */
	@Override
	public T findById(Serializable id) {

		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * ��ѯ�û���Ϣ
	 */
	@Override
	public List<T> findByExample(Example example) {

		return mapper.selectByExample(example);
	}

	/**
	 * ͨ������ʵ������ѯ�û���Ϣ
	 */
	@Override
	public List<T> findByEntity(T t) {

		return this.mapper.select(t);
	}

}
