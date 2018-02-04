package com.woniuxy.designmodel.singleton;

/**
 * 恶汉式单例模式
 * 
 * @author Administrator
 *
 */
public class HungerManModelSingleton {
	private HungerManModelSingleton() {

	}

	// 在类加载的时候获取实例
	private static final HungerManModelSingleton HUNGERMANMODELSINGLETON = new HungerManModelSingleton();

	public static HungerManModelSingleton getInstance() {

		return HUNGERMANMODELSINGLETON;
	}
}
