package com.woniuxy.designmodel.factorymethod;

/**
 * 客户类
 * 
 * @author Administrator
 *
 */
public class Customer {
	public static void main(String[] args) {
		// 生产指定的宝马车
		Factory factory = new Factory();
		factory.createBMW(230);
		factory.createBMW(253);
	}
}
