package com.woniuxy.spring.beans;

import java.util.List;
import java.util.Set;

public class UserDAO {
	/**
	 * 定义一个带参数的List集合的方法
	 * @param string
	 */
	public void setList(List<String> string) {
		//遍历输出List集合的值
		for (String string2 : string) {
			System.out.println(string2);
		}
	}

	/**
	 * 定义一个带参数 Set集合的方法
	 * 
	 * @param string
	 */
	public void setSet(Set<String> string) {
		//遍历输出set集合的值
		for (String string2 : string) {
			System.out.println(string2);
		}
	}
	
	public void save() {
		System.out.println(this.getClass().getName() + "save");
	}
}
