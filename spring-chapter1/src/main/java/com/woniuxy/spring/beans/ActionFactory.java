package com.woniuxy.spring.beans;

public class ActionFactory {
	// 无参构造方法
	public ActionFactory() {

	}

	// 带参构造方法
	public ActionFactory(String name) {

		System.out.println(name);
	}

	/**
	 * 定义获取一个实体对象的一个实例的方法
	 * 
	 * @param name
	 * @return
	 */
	public UserAction getInstance(String name) {

		return new UserAction(name);
	}
}
