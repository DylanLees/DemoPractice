package com.woniuxy.spring.interf;

public interface TransactionManagement {
	/**
	 * ��������
	 */
	void open();

	/**
	 * �ύ����
	 */
	void commit();

	/**
	 * �ع�����
	 */
	void rollBack();

}
