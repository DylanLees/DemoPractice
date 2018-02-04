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
		// ����һ�����϶������ڴ洢ѧ����Ϣ
		List<Vi_StudentsPO> studentsInfo = new ArrayList<Vi_StudentsPO>();
		// ��ȡ���ݿ�����
		JDBCConnection jdbc = new JDBCConnection();
		Connection con = jdbc.getConnection();
		//׼��sql���
		String sql="select * from vi_studentsinfo";//����ͼ�н��в�ѯ�������ؽ����
		
		try {
			//��ȡԤ����״̬
			PreparedStatement state = con.prepareStatement(sql);
			//ִ��sql������һ�������
			ResultSet res = state.executeQuery();
			while(res.next()){
				//ʵ����StudentsPO��
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
