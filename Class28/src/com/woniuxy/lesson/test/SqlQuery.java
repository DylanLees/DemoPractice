package com.woniuxy.lesson.test;

import java.lang.reflect.Field;

public class SqlQuery {
	public static void main(String[] args) throws Exception {
		// ���ô���sql��ѯ���ķ���
		select();
	}

	/**
	 * ���崴��sql��ѯ���ķ���
	 * 
	 * @throws Exception
	 */
	public static void select() throws Exception {
		// ʵ����UserPO����
		UserPO us = new UserPO();
		us.setUserName("����");
		us.setUserPass("zs123");
		 us.setRole(1);
//		 us.setId(1);
		 us.setFlag(1);// 1��ʾ���Ա�ɾ����2��ʾ�����Ա�ɾ��
		// ��ȡclass����
		Class<UserPO> user = UserPO.class;
		// ����һ��StringBuilder����
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from ");
		// �ж�UserPO��class�������Ƿ����ע��
		boolean annotationPresent = user.isAnnotationPresent(Table.class);
		if (annotationPresent) {
			// ��ȡ�����ע��
			Table declaredAnnotation = user.getDeclaredAnnotation(Table.class);
			// ��ȡ����
			String name = declaredAnnotation.name();
			System.out.println(name);
			stringBuilder.append(name);
			stringBuilder.append(" where 1=1");
			// ��ȡ����
			Field[] declaredFields = user.getDeclaredFields();
			// ����declaredFields���飨�����൱��ѭ����
			for (int i = 0; i < declaredFields.length; i++) {
				// �ж��������Ƿ�����е�ע��
				boolean annotationPresent2 = declaredFields[i].isAnnotationPresent(Column.class);
				System.out.println("�е�ע�⣺" + annotationPresent2);
				if (annotationPresent2) {
					// ��ȡ�е�ע��
					Column declaredAnnotation2 = declaredFields[i].getDeclaredAnnotation(Column.class);
					// ��ȡ���е�����
					String name2 = declaredAnnotation2.name();
					System.out.println("������" + name2);
					// �������Կ��Ա�����
					declaredFields[i].setAccessible(true);
					Object val = declaredFields[i].get(us);
					System.out.println(declaredFields[i].getName() + "------" + val);
					// �ж�val�����Ƿ����ַ�����������ַ���ִ�и�if��������
					if (val instanceof String) {
						// ����sql������where�Ĳ�ѯ����
						stringBuilder.append(" and ");
						stringBuilder.append(declaredFields[i].getName() + " =`" + val + "`");
					} else if (val == null) { // ���val����Ϊ����ʲôҲ��ִ��

					} else if (!val.equals(0)) { // ���val�����ֵ��Ϊ0����ִ�и��ж�����е�����
						stringBuilder.append(" and ");
						stringBuilder.append(declaredFields[i].getName() + " =" + val);
					}
				}
			}
		}
		// �����ѯ�����ݵ�sql���
		System.out.println(stringBuilder);
	}
}
