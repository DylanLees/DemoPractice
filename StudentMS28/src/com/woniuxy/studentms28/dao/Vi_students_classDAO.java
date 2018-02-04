package com.woniuxy.studentms28.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.studentms28.dao.po.Vi_students_classPO;
import com.woniuxy.studentms28.tools.JDBConnection;

public class Vi_students_classDAO {

	public List<Vi_students_classPO> findAll() {
		List<Vi_students_classPO> list = new ArrayList<Vi_students_classPO>();
		//获取连接
		JDBConnection jdbc = new JDBConnection();
		Connection con = jdbc.getConnection();
		//准备sql
		String sql = "select * from vi_students_class";
		//执行sql
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet set = state.executeQuery();
			while(set.next()){
				Vi_students_classPO po = new Vi_students_classPO();
				po.setAge(set.getInt("age"));
				po.setCid(set.getInt("cid"));
				po.setCname(set.getString("cname"));
				po.setSex(set.getString("sex"));
				po.setSid(set.getInt("sid"));
				po.setSname(set.getString("sname"));
				list.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbc.closeCon(con);
		}
		return list;
	}

}
