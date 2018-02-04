package com.woniuxy.spring.beans;

public class UserAction1 {
	private UserDAO dao;

	/**
	 * 定义一个带参的构造方法，传入的参数是对象
	 * 
	 * @param userDao
	 */
	public UserAction1(UserDAO userDao) {
		this.dao = userDao;
	}

	public void init() {
		System.out.println("初始化");
	}

	/**
	 * set方法注入
	 */
	// public void setUserDAO(UserDAO userDao){
	//
	// this.dao=userDao;
	//
	// }
	public void save() {
		System.out.println(this.getClass().getName() + "save");
		this.dao.save();
	}

}
