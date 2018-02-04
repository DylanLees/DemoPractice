package com.woniuxy.studentsms.service;

import com.woniuxy.studentsms.dao.UsersDAO;
import com.woniuxy.studentsms.utils.MD5_Encoding;

public class LoginService {

	public boolean checkLogin(String userName, String userPass) {
		boolean re = false;// 默认登录失败
		// 实例UserDAO类，并调用里面的通过用户名找到密码的方法
		UsersDAO usersDAO = new UsersDAO();
		String realPass = usersDAO.findUserNameByUserPass(userName);
		System.out.println(MD5_Encoding.MD5(userPass));
		// 根据返回的realPass判断和页面请求的密码是否一致，如果一致则返回一个判断结果
		if (realPass.length() > 0 && MD5_Encoding.MD5(userPass).equals(realPass)) {
			re = true;// 将结果查找的结果赋值为true
		}
		return re;

	}

}
