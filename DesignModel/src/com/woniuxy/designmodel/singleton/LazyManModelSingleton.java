package com.woniuxy.designmodel.singleton;

/**
 * 懒汉式单例模式
 * 
 * @author Administrator
 *
 */
public class LazyManModelSingleton {
	private LazyManModelSingleton() {

	}

	private static LazyManModelSingleton lazyManModelSingleton = null;

	/**
	 * 定义获取实例对象的方法，当需要使用的时候才进行实例化
	 * 
	 * @return
	 */
	public LazyManModelSingleton getInstance() {
		if (lazyManModelSingleton == null) {
			new LazyManModelSingleton();
		}
		return lazyManModelSingleton;

	}
}
