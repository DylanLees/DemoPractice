package com.woniuxy.studentsms.service;

import com.woniuxy.studentsms.dao.UsersDAO;
import com.woniuxy.studentsms.utils.MD5_Encoding;

public class RegisterService {

	public boolean checkRegister(String userName, String userPass, String confirmPass) {
		// 定义一个boolean值用于接收判断的结果
		boolean re = false;
		// 判断用户名是否已经被注册
		if(userPass.equals(confirmPass)&&userName.length()>0){
			UsersDAO dao = new UsersDAO();
			int id = dao.findIdByUserName(userName);
			if (id>0) {
				re = false;
			}
			//调用注册用户数据的方法
			re=dao.insert(userName,MD5_Encoding.MD5(userPass));
			
		}
		
		return re;
	}
}
