package com.woniuxy.lesson.test;

import java.lang.reflect.Method;

public class ReflectTest2 {
	public static void main(String[] args) throws Exception {
		Class<User> cl = User.class;
		// ��ȡset���������������
		Method method = cl.getMethod("setName", String.class);
		// ��ȡget����
		Method method2 = cl.getMethod("getName");
		// ����һ��ʵ��
		User newInstance = cl.newInstance();
		// ����cl�еķ�����������һ��ʵ������
		method.invoke(newInstance, "����");
		System.out.println(method2.invoke(newInstance));

	}
}
