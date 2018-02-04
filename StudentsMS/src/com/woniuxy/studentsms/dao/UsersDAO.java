package com.woniuxy.studentsms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniuxy.studentsms.utils.JDBCConnection;

/**
 * 用于对数据库进行增、删、改、查的操作方法定义
 * 
 * @author Administrator
 *
 */
public class UsersDAO {

	public String findUserNameByUserPass(String userName) {
		// 定义一个变量用于接收查到的用户密码
		String realPass = "";
		// 获取数据库连接
		JDBCConnection jdbc = new JDBCConnection();
		Connection con = jdbc.getConnection();
		// 准备sql语句
		String sql = "select userPass from users where userName=? and flag=0";
		// 执行sql语句
		try {
			// 获取状态
			PreparedStatement state = con.prepareStatement(sql);
			// 设置参数
			state.setString(1, userName);
			// 返回一个结果集
			ResultSet res = state.executeQuery();
			// 由于查询的是一行的数据，所有用if条件判断就行
			if (res.next()) {
				// 从数据库获取找到的用户密码并返回
				realPass = res.getString("userPass");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			jdbc.closeConnection(con);
		}
		return realPass;

	}

	public int findIdByUserName(String userName) {
		// 定义一个变量用于接收用户名
		int id = 0;
		// 获取数据库连接
		JDBCConnection jdbc = new JDBCConnection();
		Connection con = jdbc.getConnection();
		// 准备sql语句
		String sql = "select id from users where userName=?";
		// 执行sql语句
		try {
			PreparedStatement state = con.prepareStatement(sql);
			// 设置参数
			state.setString(1, userName);
			// 执行sql
			ResultSet res = state.executeQuery();
			if (res.next()) {
				id = res.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			jdbc.closeConnection(con);
		}
		return id;
	}

	public boolean insert(String userName, String userPass) {
		boolean re = false;
		// 获取数据库连接
		JDBCConnection jdbc = new JDBCConnection();
		Connection con = jdbc.getConnection();
		// 准备sql语句
		String sql = "insert into users (userName,userPass) values(?,?)";
		try {
			// 获取状态
			PreparedStatement state = con.prepareStatement(sql);
			// 设置参数
			state.setString(1, userName);
			state.setString(2, userPass);
			// 执行sql
			int res = state.executeUpdate();
			if (res > 0) {
				re = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			jdbc.closeConnection(con);
		}

		return re;

	}

}
