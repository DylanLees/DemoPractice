package com.woniuxy.spring.service;

/**
 * ����ʵ��֧�����ܵĽӿ�
 * @author Dylan
 *
 */
public interface PayService {
	/**
	 * ͨ������֧��
	 * 
	 * @param money
	 */
	String payByPoint(double money);

	/**
	 * ͨ���ֽ�֧��
	 * 
	 * @param moeny
	 */
	String payByDollar(double moeny);
}
