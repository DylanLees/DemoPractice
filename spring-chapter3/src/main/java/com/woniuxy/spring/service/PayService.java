package com.woniuxy.spring.service;

/**
 * 定义实现支付功能的接口
 * @author Dylan
 *
 */
public interface PayService {
	/**
	 * 通过积分支付
	 * 
	 * @param money
	 */
	String payByPoint(double money);

	/**
	 * 通过现金支付
	 * 
	 * @param moeny
	 */
	String payByDollar(double moeny);
}
