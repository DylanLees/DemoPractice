package com.woniuxy.designmodel.singleton;

/**
 * ��ʽ����ģʽ
 * 
 * @author Administrator
 *
 */
public class HungerManModelSingleton {
	private HungerManModelSingleton() {

	}

	// ������ص�ʱ���ȡʵ��
	private static final HungerManModelSingleton HUNGERMANMODELSINGLETON = new HungerManModelSingleton();

	public static HungerManModelSingleton getInstance() {

		return HUNGERMANMODELSINGLETON;
	}
}
