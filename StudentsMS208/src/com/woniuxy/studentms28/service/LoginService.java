package com.woniuxy.studentms28.service;

import java.util.List;

import com.woniuxy.studentms28.dao.UsersDAO;
import com.woniuxy.studentms28.dao.Vi_students_classDAO;
import com.woniuxy.studentms28.dao.po.Vi_students_classPO;
import com.woniuxy.studentms28.tools.MD5_Encoding;

public class LoginService {
	public boolean checkLogin(String paccount,String ppass, String vercode, Object realVercode){
		boolean re = false;
		if(vercode == null || vercode.length() < 1 || realVercode == null 
				|| !vercode.equalsIgnoreCase((String)realVercode)){
			return re;
		}
		UsersDAO dao = new UsersDAO();
		String pass = dao.findPassByAccount(paccount);
		MD5_Encoding md5 = new MD5_Encoding();
		if(pass.length() > 0 && pass.equals(md5.getMD5ofStr(ppass))){
			re = true;
		}
		return re;
	}

	
}
