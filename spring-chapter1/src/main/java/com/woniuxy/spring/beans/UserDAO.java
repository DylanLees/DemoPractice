package com.woniuxy.spring.beans;

import java.util.List;
import java.util.Set;

public class UserDAO {
	/**
	 * ����һ����������List���ϵķ���
	 * @param string
	 */
	public void setList(List<String> string) {
		//�������List���ϵ�ֵ
		for (String string2 : string) {
			System.out.println(string2);
		}
	}

	/**
	 * ����һ�������� Set���ϵķ���
	 * 
	 * @param string
	 */
	public void setSet(Set<String> string) {
		//�������set���ϵ�ֵ
		for (String string2 : string) {
			System.out.println(string2);
		}
	}
	
	public void save() {
		System.out.println(this.getClass().getName() + "save");
	}
}
