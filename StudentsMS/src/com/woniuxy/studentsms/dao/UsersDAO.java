package com.woniuxy.studentsms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniuxy.studentsms.utils.JDBCConnection;

/**
 * ���ڶ����ݿ��������ɾ���ġ���Ĳ�����������
 * 
 * @author Administrator
 *
 */
public class UsersDAO {

	public String findUserNameByUserPass(String userName) {
		// ����һ���������ڽ��ղ鵽���û�����
		String realPass = "";
		// ��ȡ���ݿ�����
		JDBCConnection jdbc = new JDBCConnection();
		Connection con = jdbc.getConnection();
		// ׼��sql���
		String sql = "select userPass from users where userName=? and flag=0";
		// ִ��sql���
		try {
			// ��ȡ״̬
			PreparedStatement state = con.prepareStatement(sql);
			// ���ò���
			state.setString(1, userName);
			// ����һ�������
			ResultSet res = state.executeQuery();
			// ���ڲ�ѯ����һ�е����ݣ�������if�����жϾ���
			if (res.next()) {
				// �����ݿ��ȡ�ҵ����û����벢����
				realPass = res.getString("userPass");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			jdbc.closeConnection(con);
		}
		return realPass;

	}

	public int findIdByUserName(String userName) {
		// ����һ���������ڽ����û���
		int id = 0;
		// ��ȡ���ݿ�����
		JDBCConnection jdbc = new JDBCConnection();
		Connection con = jdbc.getConnection();
		// ׼��sql���
		String sql = "select id from users where userName=?";
		// ִ��sql���
		try {
			PreparedStatement state = con.prepareStatement(sql);
			// ���ò���
			state.setString(1, userName);
			// ִ��sql
			ResultSet res = state.executeQuery();
			if (res.next()) {
				id = res.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			jdbc.closeConnection(con);
		}
		return id;
	}

	public boolean insert(String userName, String userPass) {
		boolean re = false;
		// ��ȡ���ݿ�����
		JDBCConnection jdbc = new JDBCConnection();
		Connection con = jdbc.getConnection();
		// ׼��sql���
		String sql = "insert into users (userName,userPass) values(?,?)";
		try {
			// ��ȡ״̬
			PreparedStatement state = con.prepareStatement(sql);
			// ���ò���
			state.setString(1, userName);
			state.setString(2, userPass);
			// ִ��sql
			int res = state.executeUpdate();
			if (res > 0) {
				re = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ���Դ
			jdbc.closeConnection(con);
		}

		return re;

	}

}
