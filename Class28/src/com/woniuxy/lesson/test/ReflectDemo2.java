package com.woniuxy.lesson.test;

import java.lang.reflect.Field;

public class ReflectDemo2 {
	public static void main(String[] args) {
		// ��ȡUserPO��class����
		Class<UserPO> cl = UserPO.class;
		// �ж�ע���Ƿ����
		boolean annotationPresent = cl.isAnnotationPresent(Table.class);
		System.out.println(annotationPresent);
		//���жϱ��ע���Ƿ����
		if (annotationPresent) {
			// ��ȡUserPO�ı���
			Table declaredAnnotation = cl.getDeclaredAnnotation(Table.class);
			// ��ȡע�������ֵ
			String name = declaredAnnotation.name();
			System.out.println("������" + name);
		}

		// ��ȡ���Ե�ע��ֵ
		Field[] fields = cl.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			// ���ж��е�ע���Ƿ����
			if (fields[i].isAnnotationPresent(Column.class)) {
				// ����һ��Columnע����󣬲�������е�����
				Column declaredAnnotation2 = fields[i].getDeclaredAnnotation(Column.class);
				String name2 = declaredAnnotation2.name();// ��ȡ������ע���ֵ
				System.out.println("������" + name2);
			}

		}

	}
}
