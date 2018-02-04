package com.woniuxy.lesson.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {
	/*
	 * ע�⾲̬����Ҫȫ����д��
	 */
	// ��ȡ���ݿ��ַ
	public static final String URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=utf-8";
	// ��ȡ���ݿ��û���
	public static final String USERNAME = "root";
	// ��ȡ���ݿ�����
	public static final String USERPASS = "";

	/**
	 * �����ȡ���ݿ����ӵķ���
	 * 
	 * @param args
	 */
	public Connection getConnection() {
		Connection con = null;// �������ӵı���
		try {
			// �������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ���ݿ�����
			con = DriverManager.getConnection(URL, USERNAME, USERPASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * �����ѯ���ķ���
	 * 
	 * @param args
	 * @return
	 */
	public List<StudentsPO> select() {
		// ��ȡ����
		Connection con = getConnection();
		// ����һ��list���϶���
		List<StudentsPO> spo = null;
		spo = new ArrayList<StudentsPO>();
		// ����sql���
		// String sql="insert into students(sname,age,sex)
		// values('����',22,'��')";
		String sql = "select * from students";

		try {
			// ����sql״̬
			Statement state = con.createStatement();
			// ִ��sql���
			ResultSet res = state.executeQuery(sql);// ����һ�������
			// System.out.println(next);
			while (res.next()) { // ѭ��һ�β������ݿ��һ�н��
				StudentsPO studentsPO = new StudentsPO();
				studentsPO.setSname(res.getString("sname"));
				studentsPO.setAge(res.getInt("age"));
				studentsPO.setSex(res.getString("sex"));
				studentsPO.setId(res.getInt("id"));
				spo.add(studentsPO);

			}
			// ��������Ԫ�أ���������
			// for (StudentsPO studentsPO : spo) {
			// System.out.println(studentsPO);
			// }
			for (int i = 0; i < spo.size(); i++) {
				System.out.println(spo.get(i));
			}
			closeConnection(con, state);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ����һ���洢�����ݿ�ѧ�������ݵļ���
		return spo;

	}

	/**
	 * �ر����ݿ�����
	 * 
	 * @param args
	 */
	public void closeConnection(Connection con, Statement state) {
		try {
			// �ر����ݿ�����
			con.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����ȡ�������ݷ���
	 */
	public int insert() {
		int re = 0;
		// ��ȡ����
		Connection con = getConnection();
		// ����sql���
		String sql = "insert into students(sname,age,sex)  values('����',22,'��')";

		try {
			// ����sql״̬statement
			Statement state = con.createStatement();
			// ִ��sql���
			re = state.executeUpdate(sql);// ����һ�������
			System.out.println("���ݲ���ɹ�");
			// �ͷ���Դ
			closeConnection(con, state);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ����һ���洢�����ݿ�ѧ�������ݵļ���
		return re;

	}

	/**
	 * ����������ݷ���
	 */
	public int update() {
		int re = 0;
		Connection con = getConnection();
		// ����sql���
		String sql = "update students set sname='����'where sname='����'";

		try {
			// ����sql״̬
			Statement state = con.createStatement();
			re = state.executeUpdate(sql);
			System.out.println("���ݸ��³ɹ�");
			closeConnection(con, state);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}

	/**
	 * ����ɾ�����ݵķ���
	 */
	public int delete() {
		int re = 0;
		// ��ȡ���ݿ�����
		Connection con = getConnection();
		// ����sql���
		String sql = "delete from students where sname='����'";
		try {
			// ����state
			Statement state = con.createStatement();
			// ִ��state
			re = state.executeUpdate(sql);
			System.out.println("ɾ���ɹ�");
			closeConnection(con, state);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return re;

	}

	/**
	 * Ԥ����״ִ̬��sql���
	 */
	public int execute() {
		int re = 0;
		// ��ȡ���ݿ�����
		Connection con = getConnection();
		// ����sql��䣬�����û�����
		// String sql = "insert into students(sname,age,sex,id)
		// values(?,?,?,?)";
		// ɾ���û�����
		String sql = "delete from students where sname='����'";
		// ִ��sql���
		try {
			// ��ȡsqlԤ����״̬
			PreparedStatement state = con.prepareStatement(sql);
			// // ��state����
			//
			// state.setString(1, "����");
			// state.setInt(2, 12);
			// state.setString(3, "Ů");
			// state.setInt(4, 3);
			// ִ��state
			re = state.executeUpdate();// ������SQL���ִ��Ӱ�������
			System.out.println("���ݲ���ɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return re;

	}

	/**
	 * �������ô洢���̵ķ���
	 * 
	 * @param args
	 * 
	 */
	public void call_pro() {
		// ��ȡ���ݿ�����
		Connection con = getConnection();
		// ���������ύ��ʽΪ���Զ��ύ
		try {
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ����sql���
		String sql = "{call pro_student(?,?,?,?,?)}";//�������ô洢���̵�sql���
		// ִ��sql
		try {
			CallableStatement prepareCall = con.prepareCall(sql);
			// ��prepareCall�󶨲���
			prepareCall.setString(1, "����");
			prepareCall.setString(2, "zx123");
			prepareCall.setString(3, "������");
			prepareCall.setInt(4, 25);
			prepareCall.setString(5, "��");
			prepareCall.execute();
			System.out.println("���ô洢���̳ɹ�");
			// �ύ����
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JdbcTest jdbcTest = new JdbcTest();
		// jdbcTest.select();//����select��ѯ���ݷ���
		// jdbcTest.insert();//����insert�������ݷ���
		// jdbcTest.update();//����update�������ݷ���
		// jdbcTest.delete();//����deleteɾ�����ݷ���
		// jdbcTest.execute();//����executeִ�з���
		jdbcTest.call_pro();//���ô洢���̷���
	}
}
