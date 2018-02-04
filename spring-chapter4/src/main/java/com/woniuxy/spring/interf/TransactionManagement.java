package com.woniuxy.spring.interf;

public interface TransactionManagement {
	/**
	 * 开启事务
	 */
	void open();

	/**
	 * 提交事务
	 */
	void commit();

	/**
	 * 回滚事务
	 */
	void rollBack();

}
