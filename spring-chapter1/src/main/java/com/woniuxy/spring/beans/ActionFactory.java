package com.woniuxy.spring.beans;

public class ActionFactory {
	// �޲ι��췽��
	public ActionFactory() {

	}

	// ���ι��췽��
	public ActionFactory(String name) {

		System.out.println(name);
	}

	/**
	 * �����ȡһ��ʵ������һ��ʵ���ķ���
	 * 
	 * @param name
	 * @return
	 */
	public UserAction getInstance(String name) {

		return new UserAction(name);
	}
}
