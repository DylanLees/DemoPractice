package com.woniuxy.spring.beans;

public class UserAction1 {
	private UserDAO dao;

	/**
	 * ����һ�����εĹ��췽��������Ĳ����Ƕ���
	 * 
	 * @param userDao
	 */
	public UserAction1(UserDAO userDao) {
		this.dao = userDao;
	}

	public void init() {
		System.out.println("��ʼ��");
	}

	/**
	 * set����ע��
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
