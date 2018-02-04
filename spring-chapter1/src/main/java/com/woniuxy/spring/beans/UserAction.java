package com.woniuxy.spring.beans;

public class UserAction {
	// 定义无参数的构造方法，先实例化在初始化
	public UserAction() {
		System.out.println("实例化对象");
	}

	// 带参数构造方法1
	public UserAction(String name) {
		System.err.println(name);
	}

	// 带参数构造方法2
	public UserAction(int age) {
		System.err.println(age);

	}
	/**
	 * 初始化对象
	 */
	public void init() {
		System.out.println("初始化对象");
	}

	/**
	 * 关闭IOC容器的时候调用destroy方法销毁bean对象
	 */
	public void destroy() {
		System.out.println("销毁bean对象");
	}
	
	public void save() {
		System.err.println(this.getClass().getName() + "save");
	}
}
