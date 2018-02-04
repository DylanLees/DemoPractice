package com.woniuxy.lesson.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectTest1 {
	public static void main(String[] args) {
		// ��ȡclass
		Class<Integer> cl = Integer.class;
		// ��ȡ�������η�
		int modifiers = cl.getModifiers();
		String string = Modifier.toString(modifiers);
		// ����һ��StringBuilder
		StringBuilder stringBuilder = new StringBuilder();
		// ƴ���ַ���
		stringBuilder.append(string + " ");
		stringBuilder.append("class" + " ");
		stringBuilder.append(cl.getSimpleName());
		stringBuilder.append("{ \n");
		stringBuilder.append("//����\n");

		// ��ȡ����
		Field[] declaredFields = cl.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			// ��ȡ�������η�
			int modifiers2 = declaredFields[i].getModifiers();
			String string2 = Modifier.toString(modifiers2);
			// ��ȡ�����������͵�����
			String simpleName = declaredFields[i].getType().getSimpleName();
			// ��ȡ��������
			String name = declaredFields[i].getName();
			stringBuilder.append("\t" + string2 + " ");
			stringBuilder.append(simpleName + " ");
			stringBuilder.append(name + ";" + "\n");

		}
		stringBuilder.append("//���췽��\n");
		// ��ȡ���췽��
		Constructor<?>[] declaredConstructors = cl.getDeclaredConstructors();
		for (int i = 0; i < declaredConstructors.length; i++) {
			// ��ȡ�������η�
			int modifiers2 = declaredConstructors[i].getModifiers();
			String string2 = Modifier.toString(modifiers2);
			// ��ȡ���췽������
			String simpleName = cl.getSimpleName();
			Class<?>[] parameterTypes = declaredConstructors[i].getParameterTypes();
			stringBuilder.append(string2 + " ");
			stringBuilder.append(simpleName);
			stringBuilder.append("(");
			// ��ȡ��������
			for (int j = 0; j < parameterTypes.length; j++) {
				String simpleName2 = parameterTypes[j].getSimpleName();
				stringBuilder.append(simpleName2 + " ");
				// ��ȡ��������
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

		stringBuilder.append("//��Ա����\n");
		// ��ȡ��Ա����
		Method[] declaredMethods = cl.getDeclaredMethods();
		for (int i = 0; i < declaredMethods.length; i++) {
			// ��ȡ�������η�
			int modifiers2 = declaredMethods[i].getModifiers();
			String string2 = Modifier.toString(modifiers2);
			// ��ȡ�������ص���������
			String simpleName = declaredMethods[i].getReturnType().getSimpleName();
			// ��ȡ��������
			String name = declaredMethods[i].getName();
			stringBuilder.append(string2 + " ");
			stringBuilder.append(simpleName + " ");
			stringBuilder.append(name + " ");
			stringBuilder.append("(");
			// ��ȡ��������
			Class<?>[] parameterTypes = declaredMethods[i].getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				// ��ȡ��������Ĳ�������
				String simpleName2 = parameterTypes[j].getSimpleName();
				stringBuilder.append(simpleName2 + " ");
				// ��ȡ��������
				Parameter[] parameters = declaredMethods[i].getParameters();
				String name2 = parameters[j].getName();
				stringBuilder.append(name2);
				// �������б�����Ĳ����ö��ŷָ���
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
