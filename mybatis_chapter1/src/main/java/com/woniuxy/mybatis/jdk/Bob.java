package com.woniuxy.mybatis.jdk;

/**
 * ����һ������ʵ��Person�ӿ��еĹ�����Ʒ�ķ���
 * 
 * @author Administrator
 *
 */
public class Bob implements Person {

	@Override
	public String buy(String name) {
		// ���bob����
		System.out.println("����  ���� " + name);
		return "�ɹ�";
	}

}
