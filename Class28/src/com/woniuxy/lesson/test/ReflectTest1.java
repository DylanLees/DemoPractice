package com.woniuxy.lesson.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectTest1 {
	public static void main(String[] args) {
		// 获取class
		Class<Integer> cl = Integer.class;
		// 获取访问修饰符
		int modifiers = cl.getModifiers();
		String string = Modifier.toString(modifiers);
		// 创建一个StringBuilder
		StringBuilder stringBuilder = new StringBuilder();
		// 拼接字符串
		stringBuilder.append(string + " ");
		stringBuilder.append("class" + " ");
		stringBuilder.append(cl.getSimpleName());
		stringBuilder.append("{ \n");
		stringBuilder.append("//属性\n");

		// 获取属性
		Field[] declaredFields = cl.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			// 获取访问修饰符
			int modifiers2 = declaredFields[i].getModifiers();
			String string2 = Modifier.toString(modifiers2);
			// 获取属性数据类型的名称
			String simpleName = declaredFields[i].getType().getSimpleName();
			// 获取属性名称
			String name = declaredFields[i].getName();
			stringBuilder.append("\t" + string2 + " ");
			stringBuilder.append(simpleName + " ");
			stringBuilder.append(name + ";" + "\n");

		}
		stringBuilder.append("//构造方法\n");
		// 获取构造方法
		Constructor<?>[] declaredConstructors = cl.getDeclaredConstructors();
		for (int i = 0; i < declaredConstructors.length; i++) {
			// 获取访问修饰符
			int modifiers2 = declaredConstructors[i].getModifiers();
			String string2 = Modifier.toString(modifiers2);
			// 获取构造方法名称
			String simpleName = cl.getSimpleName();
			Class<?>[] parameterTypes = declaredConstructors[i].getParameterTypes();
			stringBuilder.append(string2 + " ");
			stringBuilder.append(simpleName);
			stringBuilder.append("(");
			// 获取参数类型
			for (int j = 0; j < parameterTypes.length; j++) {
				String simpleName2 = parameterTypes[j].getSimpleName();
				stringBuilder.append(simpleName2 + " ");
				// 获取参数名称
				Parameter[] parameters = declaredConstructors[i].getParameters();
				String name = parameters[j].getName();
				stringBuilder.append(name);
				if (j < parameters.length - 1) {
					stringBuilder.append(",");
				}
			}
			stringBuilder.append(")");
			stringBuilder.append("{\n");

			stringBuilder.append("}");
			stringBuilder.append("\n");

		}

		stringBuilder.append("//成员方法\n");
		// 获取成员方法
		Method[] declaredMethods = cl.getDeclaredMethods();
		for (int i = 0; i < declaredMethods.length; i++) {
			// 获取访问修饰符
			int modifiers2 = declaredMethods[i].getModifiers();
			String string2 = Modifier.toString(modifiers2);
			// 获取方法返回的数据类型
			String simpleName = declaredMethods[i].getReturnType().getSimpleName();
			// 获取方法名称
			String name = declaredMethods[i].getName();
			stringBuilder.append(string2 + " ");
			stringBuilder.append(simpleName + " ");
			stringBuilder.append(name + " ");
			stringBuilder.append("(");
			// 获取参数类型
			Class<?>[] parameterTypes = declaredMethods[i].getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				// 获取方法传入的参数类型
				String simpleName2 = parameterTypes[j].getSimpleName();
				stringBuilder.append(simpleName2 + " ");
				// 获取参数名称
				Parameter[] parameters = declaredMethods[i].getParameters();
				String name2 = parameters[j].getName();
				stringBuilder.append(name2);
				// 给参数列表里面的参数用逗号分隔开
				if (j < parameters.length - 1) {
					stringBuilder.append(",");
				}
			}
			stringBuilder.append(")");
			stringBuilder.append("{\n");
			stringBuilder.append("}");
			stringBuilder.append("\n");
		}
		stringBuilder.append("}");
		System.out.println(stringBuilder);
	}
}
