package com.woniuxy.spring.impl;

import com.woniuxy.spring.interf.TransactionManagement;

public class HibernateTransactionManagement implements TransactionManagement {

	@Override
	public void open() {
		System.out.println("hibernate开启事务");

	}

	@Override
	public void commit() {
		System.out.println("hibernate提交事务");

	}

	@Override
	public void rollBack() {
		System.out.println("hibernate回滚事务");

	}

}
