package test2;

import java.io.Serializable;

/**
 * 实现序列化
 * 
 * @author Administrator
 *
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	// 定义成员变量
	private String name;
	private int age;

	/**
	 * 定义带参数的构造方法
	 * 
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 重写toString方法
	@Override
	public String toString() {
		return "姓名：" + this.name + "年龄：" + age;
	}
}
