package com.woniuxy.lesson.test;

import java.lang.reflect.Field;

public class ReflectDemo2 {
	public static void main(String[] args) {
		// 获取UserPO的class对象
		Class<UserPO> cl = UserPO.class;
		// 判断注解是否存在
		boolean annotationPresent = cl.isAnnotationPresent(Table.class);
		System.out.println(annotationPresent);
		//先判断表的注解是否存在
		if (annotationPresent) {
			// 获取UserPO的表名
			Table declaredAnnotation = cl.getDeclaredAnnotation(Table.class);
			// 获取注解里面的值
			String name = declaredAnnotation.name();
			System.out.println("表名：" + name);
		}

		// 获取属性的注解值
		Field[] fields = cl.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			// 先判断列的注解是否存在
			if (fields[i].isAnnotationPresent(Column.class)) {
				// 传入一个Column注解对象，并输出所有的列名
				Column declaredAnnotation2 = fields[i].getDeclaredAnnotation(Column.class);
				String name2 = declaredAnnotation2.name();// 获取属性中注解的值
				System.out.println("列名：" + name2);
			}

		}

	}
}
