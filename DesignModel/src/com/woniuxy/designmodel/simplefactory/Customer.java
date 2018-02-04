package com.woniuxy.designmodel.simplefactory;

/**
 * 简单工厂模式
 * 
 * @author Administrator
 *
 */
public class Customer {
	/*
	 * 工厂模式可以分为三类： 1）简单工厂模式（Simple Factory） 2）工厂方法模式（Factory Method）
	 * 3）抽象工厂模式（Abstract Factory）
	 */
	public static void main(String[] args) {
		// 客户选择自己需要制造的车型系列
		BMW230 bmw230 = new BMW230();// 调用对应创建宝马车的类里面的方法
		BMW253 bmw253 = new BMW253();

	}

}
