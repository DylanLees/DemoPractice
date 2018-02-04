package com.woniuxy.studentms28.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniuxy.studentms28.tools.JDBConnection;

public class UsersDAO {
	
	/**
	 * 根据账号查找密码
	 * @param paccount
	 * @return
	 */
	public String findPassByAccount(String paccount){
		String pass="";
		//获取连接
		JDBConnection jdbc = new JDBConnection();
		Connection con = jdbc.getConnection();
		
		//准备SQL
		String sql="select pass from users where account=? and flag=0";
		//执行sql
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setString(1, paccount);
			ResultSet set = state.executeQuery();
			if(set.next()){
				pass = set.getString("pass");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbc.closeCon(con);
		}
		return pass;
	}

	/**
	 * 根据账户查找ID
	 * @param account
	 * @return
	 */
	public int findIdByAccount(String account) {
		int id = 0;
		JDBConnection jdbc = new JDBConnection();
		//获取数据库连接
		Connection con = jdbc.getConnection();
		//准备sql
		String sql = "select id from users where account=? and flag=0";
		//执行sql
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setString(1, account);
			ResultSet set = state.executeQuery();
			//处理结果集
			if(set.next()){
				id = set.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbc.closeCon(con);
		}
		return id;
	}

	public boolean insert(String account, String pass) {
		boolean re = false;
		JDBConnection jdbc = new JDBConnection();
		//获取数据库连接
		Connection con = jdbc.getConnection();
		//准备sql
		String sql = "insert into users(account,pass) values(?,?)";
		
		//执行sql
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setString(1, account);
			state.setString(2, pass);
			int num = state.executeUpdate();
			//处理结果
			if(num > 0){
				re = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbc.closeCon(con);
		}
		return re;
	}
}
