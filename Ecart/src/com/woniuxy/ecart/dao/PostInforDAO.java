package com.woniuxy.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.woniuxy.ecart.dao.po.RegisterPO;
import com.woniuxy.ecart.tools.JDBCDatabase;

/**
 * 调用存储过程用于用户信息和邮递信息的注册
 * @author Administrator
 *
 */
public class PostInforDAO {
	/**
	 * 定义存储用户邮递信息的方法
	 */
	public boolean pro_register(RegisterPO rpo){
		boolean re=false;//默认未注册
		//获取数据库连接
		JDBCDatabase jdbc=new JDBCDatabase();
		Connection con=jdbc.getConnection();
		//创建sql语句用于调用存储过程
		String sql="call pro_register(?,?,?,?,?,?)";
		try {
			//设置事物提交方式为非自动提交（false）
			con.setAutoCommit(false);
			//创建sql的预编译状态
			PreparedStatement state=con.prepareStatement(sql);
			//给state对象里面的参数绑定相应的值
			state.setString(1, rpo.getUserName());
			state.setString(2, rpo.getPassword());
			state.setString(3, rpo.getContact());
			state.setString(4, rpo.getTel());
			state.setString(5, rpo.getMail());
			state.setString(6, rpo.getAddress());
			System.out.println(rpo.getTel()+rpo.getMail()+rpo.getAddress());
			//执行executeUpdate
			state.executeUpdate();
			//提交事务
			con.commit();
			re=true;//事务提交成功，则赋值re为true
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			//关闭数据库连接
			jdbc.closeConnection(con);
		}
		return re;
	}

}
