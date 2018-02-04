package com.woniuxy.designmodel.singleton;

/**
 * ����ʽ����ģʽ
 * 
 * @author Administrator
 *
 */
public class LazyManModelSingleton {
	private LazyManModelSingleton() {

	}

	private static LazyManModelSingleton lazyManModelSingleton = null;

	/**
	 * �����ȡʵ������ķ���������Ҫʹ�õ�ʱ��Ž���ʵ����
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
