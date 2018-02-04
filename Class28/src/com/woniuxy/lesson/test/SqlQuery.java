package com.woniuxy.lesson.test;

import java.lang.reflect.Field;

public class SqlQuery {
	public static void main(String[] args) throws Exception {
		// 调用创建sql查询语句的方法
		select();
	}

	/**
	 * 定义创建sql查询语句的方法
	 * 
	 * @throws Exception
	 */
	public static void select() throws Exception {
		// 实例化UserPO对象
		UserPO us = new UserPO();
		us.setUserName("张三");
		us.setUserPass("zs123");
		 us.setRole(1);
//		 us.setId(1);
		 us.setFlag(1);// 1表示可以被删除，2表示不可以被删除
		// 获取class对象
		Class<UserPO> user = UserPO.class;
		// 创建一个StringBuilder对象
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from ");
		// 判断UserPO的class对象中是否存在注解
		boolean annotationPresent = user.isAnnotationPresent(Table.class);
		if (annotationPresent) {
			// 获取表类的注解
			Table declaredAnnotation = user.getDeclaredAnnotation(Table.class);
			// 获取表名
			String name = declaredAnnotation.name();
			System.out.println(name);
			stringBuilder.append(name);
			stringBuilder.append(" where 1=1");
			// 获取属性
			Field[] declaredFields = user.getDeclaredFields();
			// 迭代declaredFields数组（迭代相当于循环）
			for (int i = 0; i < declaredFields.length; i++) {
				// 判断属性中是否存在列的注解
				boolean annotationPresent2 = declaredFields[i].isAnnotationPresent(Column.class);
				System.out.println("列的注解：" + annotationPresent2);
				if (annotationPresent2) {
					// 获取列的注解
					Column declaredAnnotation2 = declaredFields[i].getDeclaredAnnotation(Column.class);
					// 获取表中的列名
					String name2 = declaredAnnotation2.name();
					System.out.println("列名：" + name2);
					// 设置属性可以被访问
					declaredFields[i].setAccessible(true);
					Object val = declaredFields[i].get(us);
					System.out.println(declaredFields[i].getName() + "------" + val);
					// 判断val对象是否是字符串，如果是字符串执行该if语句的内容
					if (val instanceof String) {
						// 给出sql语句后面where的查询条件
						stringBuilder.append(" and ");
						stringBuilder.append(declaredFields[i].getName() + " =`" + val + "`");
					} else if (val == null) { // 如果val对象为空则什么也不执行

					} else if (!val.equals(0)) { // 如果val对象的值不为0，则执行该判断语句中的内容
						stringBuilder.append(" and ");
						stringBuilder.append(declaredFields[i].getName() + " =" + val);
					}
				}
			}
		}
		// 输出查询表数据的sql语句
		System.out.println(stringBuilder);
	}
}
