package com.woniuxy.spring.beans;

public class UserAction {
	// �����޲����Ĺ��췽������ʵ�����ڳ�ʼ��
	public UserAction() {
		System.out.println("ʵ��������");
	}

	// ���������췽��1
	public UserAction(String name) {
		System.err.println(name);
	}

	// ���������췽��2
	public UserAction(int age) {
		System.err.println(age);

	}
	/**
	 * ��ʼ������
	 */
	public void init() {
		System.out.println("��ʼ������");
	}

	/**
	 * �ر�IOC������ʱ�����destroy��������bean����
	 */
	public void destroy() {
		System.out.println("����bean����");
	}
	
	public void save() {
		System.err.println(this.getClass().getName() + "save");
	}
}
