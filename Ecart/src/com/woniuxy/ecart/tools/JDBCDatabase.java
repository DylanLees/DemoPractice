package com.woniuxy.ecart.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ڻ�ȡ���ݿ�����
 * 
 * @author Administrator
 *
 */
public class JDBCDatabase {
	// ���ó�Ա����
	private static final String USERNAME = "root";// ���ݿ��¼�û���
	private static final String PASSWORD = "";// ���ݿ��¼����
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/ecart?useUnicode=true&CharacterEncoding=UTF-8";
	/**
	 * �������ݿ����ӷ���
	 */
	public Connection getConnection(){
		Connection con=null;
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���ݿ�����
			con =DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * ����ر����ݿⷽ��
	 */
	public void closeConnection(Connection con){
		try {
			//�ر����ݿ�����
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
