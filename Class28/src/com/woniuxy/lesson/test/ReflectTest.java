package com.woniuxy.lesson.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// String str="hello";
		// Class<?> c1=String.class;//类名.class
		// System.out.println(c1);
		// try {
		// Class<?> c=Class.forName("java.lang.String");//Class.forName("全限定名")
		// System.out.println(c);
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// System.out.println(str.getClass());//对象名.getClass()
		// Class<?> c2=ReflectTest.class;
		// System.out.println(c2.getConstructors());

		Class<?> c = User.class;// 获取User的Class对象
		// 获取class对象的构造方法
		Constructor<?>[] constructors = c.getConstructors();

		User c1 = (User) constructors[0].newInstance();
		User c2 = (User) constructors[1].newInstance("张三", 20);
		System.out.println(c1.getName() + c1.getAge());
		System.out.println(c2.getName() + c2.getAge());
		Constructor<?> con=c.getConstructor(String.class,int.class);
		//获取构造器的实例
		User user = (User)con.newInstance("赵六",23);
		System.out.println(user.getName()+user.getAge());
		// 获取全部普通方法
		Method[] methods = c.getMethods();
		System.out.println(methods);

		// 获取属性
		Field[] declaredFields = c.getDeclaredFields();
		System.out.println(declaredFields);
		// 获取类名
		String name = c.getName();
		System.out.println(name);

	}
}
