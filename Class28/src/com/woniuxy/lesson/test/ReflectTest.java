package com.woniuxy.lesson.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// String str="hello";
		// Class<?> c1=String.class;//����.class
		// System.out.println(c1);
		// try {
		// Class<?> c=Class.forName("java.lang.String");//Class.forName("ȫ�޶���")
		// System.out.println(c);
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// System.out.println(str.getClass());//������.getClass()
		// Class<?> c2=ReflectTest.class;
		// System.out.println(c2.getConstructors());

		Class<?> c = User.class;// ��ȡUser��Class����
		// ��ȡclass����Ĺ��췽��
		Constructor<?>[] constructors = c.getConstructors();

		User c1 = (User) constructors[0].newInstance();
		User c2 = (User) constructors[1].newInstance("����", 20);
		System.out.println(c1.getName() + c1.getAge());
		System.out.println(c2.getName() + c2.getAge());
		Constructor<?> con=c.getConstructor(String.class,int.class);
		//��ȡ��������ʵ��
		User user = (User)con.newInstance("����",23);
		System.out.println(user.getName()+user.getAge());
		// ��ȡȫ����ͨ����
		Method[] methods = c.getMethods();
		System.out.println(methods);

		// ��ȡ����
		Field[] declaredFields = c.getDeclaredFields();
		System.out.println(declaredFields);
		// ��ȡ����
		String name = c.getName();
		System.out.println(name);

	}
}
