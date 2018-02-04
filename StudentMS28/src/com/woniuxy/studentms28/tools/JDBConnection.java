package com.woniuxy.studentms28.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
	//获取数据库连接
	public Connection getConnection(){
		//加载驱动
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			String url ="jdbc:mysql://localhost:3306/studentms?useUnicode=true&characterEncoding=UTF-8";
			String userName="root";
			String userPass="123456";
			con = DriverManager.getConnection(url,userName,userPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//释放资源
	public void closeCon(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
