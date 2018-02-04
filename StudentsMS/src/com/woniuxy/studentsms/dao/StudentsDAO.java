package com.woniuxy.studentsms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.studentsms.dao.po.Vi_StudentsPO;
import com.woniuxy.studentsms.utils.JDBCConnection;

public class StudentsDAO {

	public List<Vi_StudentsPO> showAllInfo() {
		// 创建一个集合对象用于存储学生信息
		List<Vi_StudentsPO> studentsInfo = new ArrayList<Vi_StudentsPO>();
		// 获取数据库连接
		JDBCConnection jdbc = new JDBCConnection();
		Connection con = jdbc.getConnection();
		//准备sql语句
		String sql="select * from vi_studentsinfo";//从视图中进行查询，并返回结果。
		
		try {
			//获取预编译状态
			PreparedStatement state = con.prepareStatement(sql);
			//执行sql，返回一个结果集
			ResultSet res = state.executeQuery();
			while(res.next()){
				//实例化StudentsPO类
				Vi_StudentsPO spo=new Vi_StudentsPO();
				spo.setId(res.getInt("id"));
				spo.setSname(res.getString("sname"));
				spo.setSex(res.getString("sex"));
				spo.setAge(res.getInt("age"));
				spo.setMajor(res.getString("major"));
				spo.setCid(res.getInt("cid"));
				spo.setCname(res.getString("cname"));
				studentsInfo.add(spo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentsInfo;
	}

}
