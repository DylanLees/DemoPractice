package com.woniuxy.lesson.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SqlSelect {
	public static void main(String[] args) throws Exception {
		// 创建一个UserPO
		UserPO us = new UserPO();
		us.setUserName("李四");
		us.setUserPass("ls123");
		us.setFlag(1);
		// 获取UserPO的class对象
		Class<UserPO> cl = UserPO.class;
		// 实例化SqlSelect类
		SqlSelect sq = new SqlSelect();
		// 调用创建sql的方法
//		StringBuilder query = sq.query(us, cl);
		String query = sq.query(us, cl);
		System.out.println(query);

	}

	/**
	 * 定义一个创建sql查询的方法
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public <T> String query(T us, Class<?> cl) throws Exception {
		// 创建一个StringBuilder，用于存储sql语句
		StringBuilder sb = new StringBuilder();
		// 判断表是否存在注解
		if (cl.isAnnotationPresent(Table.class)) {
			// 获取表的注解
			Table declaredAnnotation = cl.getDeclaredAnnotation(Table.class);
			// 获取表名称
			String name = declaredAnnotation.name();
			sb.append("select * from " + name + " where 1=1 ");
			// 获取属性
			Field[] declaredFields = cl.getDeclaredFields();
			for (int i = 0; i < declaredFields.length; i++) {
				Field fis = declaredFields[i];
				// 判断是Column是否存在
				if (!fis.isAnnotationPresent(Column.class)) {
					continue;
				}
				// 获取列的注解
				Column col = fis.getAnnotation(Column.class);
				// 获取注解的value值，即列名
				String colName = col.name();
				// 获取属性名
				String proName = fis.getName();
				// 拼接属性的get方法
				String methodName = "get" + proName.substring(0, 1).toUpperCase() + proName.substring(1);
				// 获取属性的method方法，参数为具体的方法名
				Method method = cl.getDeclaredMethod(methodName);
				// 调用method方法，并返回一个obj对象
				Object obj = method.invoke(us);
				// 判断在哪些具体情况下，不执行拼接sql的条件
				if ((obj == null) || (obj instanceof Number && ((Number) obj).doubleValue() == 0)) {
					continue;// 跳出本次循环，继续执行下一次循环。
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
