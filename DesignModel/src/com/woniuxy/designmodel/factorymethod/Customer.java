package com.woniuxy.designmodel.factorymethod;

/**
 * �ͻ���
 * 
 * @author Administrator
 *
 */
public class Customer {
	public static void main(String[] args) {
		// ����ָ���ı���
		Factory factory = new Factory();
		factory.createBMW(230);
		factory.createBMW(253);
	}
}
