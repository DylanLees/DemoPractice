package com.woniuxy.spring.impl;

import com.woniuxy.spring.interf.TransactionManagement;

public class JdbcTransactionManagement implements TransactionManagement{

	@Override
	public void open() {
		System.out.println("jdbc开启事务");
	}

	@Override
	public void commit() {
		System.out.println("jdbc提交事务");
		
	}

	@Override
	public void rollBack() {
		System.out.println("jdbc回滚事务");
		
	}

}
