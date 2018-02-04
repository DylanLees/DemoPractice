package com.woniuxy.ecart.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 用于获取数据库连接
 * 
 * @author Administrator
 *
 */
public class JDBCDatabase {
	// 设置成员属性
	private static final String USERNAME = "root";// 数据库登录用户名
	private static final String PASSWORD = "";// 数据库登录密码
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/ecart?useUnicode=true&CharacterEncoding=UTF-8";
	/**
	 * 定义数据库连接方法
	 */
	public Connection getConnection(){
		Connection con=null;
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库连接
			con =DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * 定义关闭数据库方法
	 */
	public void closeConnection(Connection con){
		try {
			//关闭数据库连接
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
