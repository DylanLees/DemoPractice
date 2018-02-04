package com.woniuxy.spring.impl;

import com.woniuxy.spring.interf.TransactionManagement;

public class HibernateTransactionManagement implements TransactionManagement {

	@Override
	public void open() {
		System.out.println("hibernate��������");

	}

	@Override
	public void commit() {
		System.out.println("hibernate�ύ����");

	}

	@Override
	public void rollBack() {
		System.out.println("hibernate�ع�����");

	}

}
