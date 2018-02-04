package com.woniuxy.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;

import com.woniuxy.spring.interf.TransactionManagement;

public class TransactionAdvice {
	private TransactionManagement transactionManagement;

	public void setTransactionManagement(TransactionManagement transactionManagement) {
		this.transactionManagement = transactionManagement;
	}

	/**
	 * 环绕增强
	 * 
	 * @return
	 */
	public Object around(ProceedingJoinPoint jointPoint) {
		Object result = null;

		try {
			// 开启事务
			transactionManagement.open();
			//调用目标对象方法
			result = jointPoint.proceed();
			// 成功，提交事务
			transactionManagement.commit();
		} catch (Throwable e) {
			// 失败则回滚
			transactionManagement.rollBack();
			e.printStackTrace();
		}

		return result;

	}
}
