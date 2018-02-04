package com.woniuxy.lesson.test;

import java.lang.reflect.Method;

public class ReflectTest2 {
	public static void main(String[] args) throws Exception {
		Class<User> cl = User.class;
		// 获取set方法，并传入参数
		Method method = cl.getMethod("setName", String.class);
		// 获取get方法
		Method method2 = cl.getMethod("getName");
		// 创建一个实例
		User newInstance = cl.newInstance();
		// 调用cl中的方法，并传入一个实例对象
		method.invoke(newInstance, "张三");
		System.out.println(method2.invoke(newInstance));

	}
}
