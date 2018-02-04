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
	 * 注意静态常量要全部大写。
	 */
	// 获取数据库地址
	public static final String URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=utf-8";
	// 获取数据库用户名
	public static final String USERNAME = "root";
	// 获取数据库密码
	public static final String USERPASS = "";

	/**
	 * 定义获取数据库连接的方法
	 * 
	 * @param args
	 */
	public Connection getConnection() {
		Connection con = null;// 定义连接的遍历
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接
			con = DriverManager.getConnection(URL, USERNAME, USERPASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 定义查询语句的方法
	 * 
	 * @param args
	 * @return
	 */
	public List<StudentsPO> select() {
		// 获取连接
		Connection con = getConnection();
		// 创建一个list集合对象
		List<StudentsPO> spo = null;
		spo = new ArrayList<StudentsPO>();
		// 创建sql语句
		// String sql="insert into students(sname,age,sex)
		// values('张三',22,'男')";
		String sql = "select * from students";

		try {
			// 创建sql状态
			Statement state = con.createStatement();
			// 执行sql语句
			ResultSet res = state.executeQuery(sql);// 返回一个结果集
			// System.out.println(next);
			while (res.next()) { // 循环一次操作数据库的一行结果
				StudentsPO studentsPO = new StudentsPO();
				studentsPO.setSname(res.getString("sname"));
				studentsPO.setAge(res.getInt("age"));
				studentsPO.setSex(res.getString("sex"));
				studentsPO.setId(res.getInt("id"));
				spo.add(studentsPO);

			}
			// 遍历集合元素，输出结果。
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
		// 返回一个存储了数据库学生表数据的集合
		return spo;

	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param args
	 */
	public void closeConnection(Connection con, Statement state) {
		try {
			// 关闭数据库连接
			con.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 定义获取增加数据方法
	 */
	public int insert() {
		int re = 0;
		// 获取连接
		Connection con = getConnection();
		// 创建sql语句
		String sql = "insert into students(sname,age,sex)  values('李四',22,'男')";

		try {
			// 创建sql状态statement
			Statement state = con.createStatement();
			// 执行sql语句
			re = state.executeUpdate(sql);// 返回一个结果集
			System.out.println("数据插入成功");
			// 释放资源
			closeConnection(con, state);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 返回一个存储了数据库学生表数据的集合
		return re;

	}

	/**
	 * 定义更新数据方法
	 */
	public int update() {
		int re = 0;
		Connection con = getConnection();
		// 创建sql语句
		String sql = "update students set sname='王五'where sname='张三'";

		try {
			// 创建sql状态
			Statement state = con.createStatement();
			re = state.executeUpdate(sql);
			System.out.println("数据更新成功");
			closeConnection(con, state);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}

	/**
	 * 定义删除数据的方法
	 */
	public int delete() {
		int re = 0;
		// 获取数据库连接
		Connection con = getConnection();
		// 创建sql语句
		String sql = "delete from students where sname='李四'";
		try {
			// 创建state
			Statement state = con.createStatement();
			// 执行state
			re = state.executeUpdate(sql);
			System.out.println("删除成功");
			closeConnection(con, state);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return re;

	}

	/**
	 * 预编译状态执行sql语句
	 */
	public int execute() {
		int re = 0;
		// 获取数据库连接
		Connection con = getConnection();
		// 创建sql语句，出入用户数据
		// String sql = "insert into students(sname,age,sex,id)
		// values(?,?,?,?)";
		// 删除用户数据
		String sql = "delete from students where sname='张三'";
		// 执行sql语句
		try {
			// 获取sql预编译状态
			PreparedStatement state = con.prepareStatement(sql);
			// // 绑定state参数
			//
			// state.setString(1, "王八");
			// state.setInt(2, 12);
			// state.setString(3, "女");
			// state.setInt(4, 3);
			// 执行state
			re = state.executeUpdate();// 返回受SQL语句执行影响的行数
			System.out.println("数据插入成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return re;

	}

	/**
	 * 创建调用存储过程的方法
	 * 
	 * @param args
	 * 
	 */
	public void call_pro() {
		// 获取数据库连接
		Connection con = getConnection();
		// 设置事务提交方式为不自动提交
		try {
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 创建sql语句
		String sql = "{call pro_student(?,?,?,?,?)}";//创建调用存储过程的sql语句
		// 执行sql
		try {
			CallableStatement prepareCall = con.prepareCall(sql);
			// 给prepareCall绑定参数
			prepareCall.setString(1, "赵信");
			prepareCall.setString(2, "zx123");
			prepareCall.setString(3, "赵子龙");
			prepareCall.setInt(4, 25);
			prepareCall.setString(5, "男");
			prepareCall.execute();
			System.out.println("调用存储过程成功");
			// 提交事务
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JdbcTest jdbcTest = new JdbcTest();
		// jdbcTest.select();//调用select查询数据方法
		// jdbcTest.insert();//调用insert插入数据方法
		// jdbcTest.update();//调用update更新数据方法
		// jdbcTest.delete();//调用delete删除数据方法
		// jdbcTest.execute();//调用execute执行方法
		jdbcTest.call_pro();//调用存储过程方法
	}
}
