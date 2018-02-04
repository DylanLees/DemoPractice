package com.woniuxy.spring.impl;

import com.woniuxy.spring.interf.TransactionManagement;

public class JdbcTransactionManagement implements TransactionManagement{

	@Override
	public void open() {
		System.out.println("jdbc��������");
	}

	@Override
	public void commit() {
		System.out.println("jdbc�ύ����");
		
	}

	@Override
	public void rollBack() {
		System.out.println("jdbc�ع�����");
		
	}

}
