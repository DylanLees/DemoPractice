package com.woniuxy.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.woniuxy.ecart.tools.JDBCDatabase;

/**
 * 操作数据库
 * @author Administrator
 *
 */
public class UserDAO {

	public String findPassByUserName(String userName) {
		// 定义一个变量pass用于接收查找的密码
		String pass = null;
		// 实例化JDBCDatabase类
		JDBCDatabase jdbc = new JDBCDatabase();
		// 获取数据库连接
		Connection con = jdbc.getConnection();
		// 创建sql语句用于通过用户名查询密码
		String sql = "select password from users where userName=?";
		try {
			// 创建sql语句的预编译状态
			PreparedStatement state = con.prepareStatement(sql);
			// 给state对象的参数绑定相应的值
			state.setString(1, userName);
			// 执行executeQuery，并返回一个结果集
			ResultSet re = state.executeQuery();
			// 判断结果集中是否存在所要查询的结果
			if (re.next()) {
				// 获取数据库中password列的值
				pass = re.getString("password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭数据库连接
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pass;
	}

	public int findIdByUserName(String userName) {
		int id=0;//设置id默认值为0
		//实例化JDBCDatabase
		JDBCDatabase jdbc=new JDBCDatabase();
		//获取数据库连接
		Connection con =jdbc.getConnection();
		//创建sql语句通过用户名查询id
		String sql="select id from users where userName=?";
		try {
			//创建sql预编译语句
			PreparedStatement state=con.prepareStatement(sql);
			//给state对象的参数绑定值
			state.setString(1, userName);
			//执行executeQuery返回一个结果集
			ResultSet re=state.executeQuery();
			if(re.next()){
				//获取数据库id列的值
				id=re.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				//关闭数据库连接
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}
}
