package com.woniuxy.studentms28.service;

import com.woniuxy.studentms28.dao.StudentsDAO;

public class DeleteService {

	public boolean deleteById(String sid) {
		boolean re = false;
		if(sid == null || sid.length() < 1){
			return re;
		}
		int stuid = 0;
		try {
			stuid = Integer.parseInt(sid);
			re = new StudentsDAO().deleteById(stuid);
		} catch (Exception e) {
			return re;
		}
		return re;
	}

}
