package com.woniuxy.studentsms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * �����ȡ���ݿ����ӵķ������ͷ���Դ��
 * 
 * @author Administrator
 *
 */
public class JDBCConnection {
	// ���ݿ����ӵ�ַ
	public static final String URL = "jdbc:mysql://localhost:3306/studentsms?useUnicode=true&characterEncoding=utf-8";
	// �����û���
	public static final String USERNAME = "root";
	// ���ݿ�����
	public static final String USERPASS = "";

/**
 * �����ȡ���ݿ����ӵķ���
 * @return
 */
	public Connection getConnection() {
		Connection con = null;
		// ��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ���ݿ�����
			con = DriverManager.getConnection(URL, USERNAME, USERPASS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}
/**
 * �����ͷ���Դ�ķ���
 * @param con
 */
	public void closeConnection(Connection con) {
		try {
			// �ͷ���Դ
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
