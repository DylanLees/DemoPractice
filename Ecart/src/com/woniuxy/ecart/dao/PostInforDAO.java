package com.woniuxy.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.woniuxy.ecart.dao.po.RegisterPO;
import com.woniuxy.ecart.tools.JDBCDatabase;

/**
 * ���ô洢���������û���Ϣ���ʵ���Ϣ��ע��
 * @author Administrator
 *
 */
public class PostInforDAO {
	/**
	 * ����洢�û��ʵ���Ϣ�ķ���
	 */
	public boolean pro_register(RegisterPO rpo){
		boolean re=false;//Ĭ��δע��
		//��ȡ���ݿ�����
		JDBCDatabase jdbc=new JDBCDatabase();
		Connection con=jdbc.getConnection();
		//����sql������ڵ��ô洢����
		String sql="call pro_register(?,?,?,?,?,?)";
		try {
			//���������ύ��ʽΪ���Զ��ύ��false��
			con.setAutoCommit(false);
			//����sql��Ԥ����״̬
			PreparedStatement state=con.prepareStatement(sql);
			//��state��������Ĳ�������Ӧ��ֵ
			state.setString(1, rpo.getUserName());
			state.setString(2, rpo.getPassword());
			state.setString(3, rpo.getContact());
			state.setString(4, rpo.getTel());
			state.setString(5, rpo.getMail());
			state.setString(6, rpo.getAddress());
			System.out.println(rpo.getTel()+rpo.getMail()+rpo.getAddress());
			//ִ��executeUpdate
			state.executeUpdate();
			//�ύ����
			con.commit();
			re=true;//�����ύ�ɹ�����ֵreΪtrue
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			//�ر����ݿ�����
			jdbc.closeConnection(con);
		}
		return re;
	}

}
