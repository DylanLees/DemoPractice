package com.woniuxy.studentms28.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.woniuxy.studentms28.tools.JDBConnection;

public class StudentsDAO {

	public boolean deleteById(int stuid) {
		boolean re = false;
		JDBConnection jdbc = new JDBConnection();
		Connection con = jdbc.getConnection();
		
		String sql = "update students set flag=1 where id=?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, stuid);
			int row = state.executeUpdate();
			if(row > 0){
				re =true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbc.closeCon(con);
		}
		return re;
	}
	
}
