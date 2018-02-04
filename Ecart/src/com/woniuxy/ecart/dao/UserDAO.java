package com.woniuxy.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.woniuxy.ecart.tools.JDBCDatabase;

/**
 * �������ݿ�
 * @author Administrator
 *
 */
public class UserDAO {

	public String findPassByUserName(String userName) {
		// ����һ������pass���ڽ��ղ��ҵ�����
		String pass = null;
		// ʵ����JDBCDatabase��
		JDBCDatabase jdbc = new JDBCDatabase();
		// ��ȡ���ݿ�����
		Connection con = jdbc.getConnection();
		// ����sql�������ͨ���û�����ѯ����
		String sql = "select password from users where userName=?";
		try {
			// ����sql����Ԥ����״̬
			PreparedStatement state = con.prepareStatement(sql);
			// ��state����Ĳ�������Ӧ��ֵ
			state.setString(1, userName);
			// ִ��executeQuery��������һ�������
			ResultSet re = state.executeQuery();
			// �жϽ�������Ƿ������Ҫ��ѯ�Ľ��
			if (re.next()) {
				// ��ȡ���ݿ���password�е�ֵ
				pass = re.getString("password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر����ݿ�����
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pass;
	}

	public int findIdByUserName(String userName) {
		int id=0;//����idĬ��ֵΪ0
		//ʵ����JDBCDatabase
		JDBCDatabase jdbc=new JDBCDatabase();
		//��ȡ���ݿ�����
		Connection con =jdbc.getConnection();
		//����sql���ͨ���û�����ѯid
		String sql="select id from users where userName=?";
		try {
			//����sqlԤ�������
			PreparedStatement state=con.prepareStatement(sql);
			//��state����Ĳ�����ֵ
			state.setString(1, userName);
			//ִ��executeQuery����һ�������
			ResultSet re=state.executeQuery();
			if(re.next()){
				//��ȡ���ݿ�id�е�ֵ
				id=re.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				//�ر����ݿ�����
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}
}
