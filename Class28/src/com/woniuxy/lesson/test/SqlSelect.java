package com.woniuxy.lesson.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SqlSelect {
	public static void main(String[] args) throws Exception {
		// ����һ��UserPO
		UserPO us = new UserPO();
		us.setUserName("����");
		us.setUserPass("ls123");
		us.setFlag(1);
		// ��ȡUserPO��class����
		Class<UserPO> cl = UserPO.class;
		// ʵ����SqlSelect��
		SqlSelect sq = new SqlSelect();
		// ���ô���sql�ķ���
//		StringBuilder query = sq.query(us, cl);
		String query = sq.query(us, cl);
		System.out.println(query);

	}

	/**
	 * ����һ������sql��ѯ�ķ���
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public <T> String query(T us, Class<?> cl) throws Exception {
		// ����һ��StringBuilder�����ڴ洢sql���
		StringBuilder sb = new StringBuilder();
		// �жϱ��Ƿ����ע��
		if (cl.isAnnotationPresent(Table.class)) {
			// ��ȡ���ע��
			Table declaredAnnotation = cl.getDeclaredAnnotation(Table.class);
			// ��ȡ������
			String name = declaredAnnotation.name();
			sb.append("select * from " + name + " where 1=1 ");
			// ��ȡ����
			Field[] declaredFields = cl.getDeclaredFields();
			for (int i = 0; i < declaredFields.length; i++) {
				Field fis = declaredFields[i];
				// �ж���Column�Ƿ����
				if (!fis.isAnnotationPresent(Column.class)) {
					continue;
				}
				// ��ȡ�е�ע��
				Column col = fis.getAnnotation(Column.class);
				// ��ȡע���valueֵ��������
				String colName = col.name();
				// ��ȡ������
				String proName = fis.getName();
				// ƴ�����Ե�get����
				String methodName = "get" + proName.substring(0, 1).toUpperCase() + proName.substring(1);
				// ��ȡ���Ե�method����������Ϊ����ķ�����
				Method method = cl.getDeclaredMethod(methodName);
				// ����method������������һ��obj����
				Object obj = method.invoke(us);
				// �ж�����Щ��������£���ִ��ƴ��sql������
				if ((obj == null) || (obj instanceof Number && ((Number) obj).doubleValue() == 0)) {
					continue;// ��������ѭ��������ִ����һ��ѭ����
				}
				if (obj instanceof String) {
					sb.append(" and `" + colName + "`=\"" + obj + "\"");
				} else {
					sb.append(" and `" + colName + "`=" + obj);
				}

			}

		}
		return sb.toString();
	}
}
