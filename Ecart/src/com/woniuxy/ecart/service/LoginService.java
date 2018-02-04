package com.woniuxy.ecart.service;

import com.woniuxy.ecart.dao.UserDAO;
import com.woniuxy.ecart.tools.MD5_Encoding;

public class LoginService {

	public boolean checkLogin(String userName, String password) {
		boolean re = false;// 默认未登录
		// 实例化UsersDAO类
		UserDAO user = new UserDAO();
		// 调用user对象里面通过账号查询密码的方法findPassByUserName()，并返回查询的用户密码
		String realpass = user.findPassByUserName(userName);
		// 判断从页面输入的密码是否和从数据库查询的密码相等
		if (realpass.equals(new MD5_Encoding().getMd5String(password)) && password != null) {
			// 返回一个true结果的boolean值
			re = true;
		}
		return re;
	}

}
