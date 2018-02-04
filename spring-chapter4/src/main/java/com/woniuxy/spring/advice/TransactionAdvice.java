package com.woniuxy.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;

import com.woniuxy.spring.interf.TransactionManagement;

public class TransactionAdvice {
	private TransactionManagement transactionManagement;

	public void setTransactionManagement(TransactionManagement transactionManagement) {
		this.transactionManagement = transactionManagement;
	}

	/**
	 * ������ǿ
	 * 
	 * @return
	 */
	public Object around(ProceedingJoinPoint jointPoint) {
		Object result = null;

		try {
			// ��������
			transactionManagement.open();
			//����Ŀ����󷽷�
			result = jointPoint.proceed();
			// �ɹ����ύ����
			transactionManagement.commit();
		} catch (Throwable e) {
			// ʧ����ع�
			transactionManagement.rollBack();
			e.printStackTrace();
		}

		return result;

	}
}
