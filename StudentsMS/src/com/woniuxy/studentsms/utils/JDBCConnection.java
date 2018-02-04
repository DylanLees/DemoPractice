package com.woniuxy.studentsms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 定义获取数据库连接的方法，释放资源。
 * 
 * @author Administrator
 *
 */
public class JDBCConnection {
	// 数据库连接地址
	public static final String URL = "jdbc:mysql://localhost:3306/studentsms?useUnicode=true&characterEncoding=utf-8";
	// 数据用户名
	public static final String USERNAME = "root";
	// 数据库密码
	public static final String USERPASS = "";

/**
 * 定义获取数据库连接的方法
 * @return
 */
	public Connection getConnection() {
		Connection con = null;
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接
			con = DriverManager.getConnection(URL, USERNAME, USERPASS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}
/**
 * 定义释放资源的方法
 * @param con
 */
	public void closeConnection(Connection con) {
		try {
			// 释放资源
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
