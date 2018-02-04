package com.woniuxy.studentms28.service;

import com.woniuxy.studentms28.dao.UsersDAO;
import com.woniuxy.studentms28.tools.MD5_Encoding;

public class RegisterService {

	public boolean register(String account, String pass, String checkpass, String vercode, Object realVercode) {
		boolean re = false;
		//检查验证码
		if(vercode == null || vercode.length() < 1 || realVercode ==null 
				|| !vercode.equalsIgnoreCase((String)vercode)){
			return re;
		}
		//检查两次密码是否一致
		if(pass == null || !pass.equals(checkpass)){
			return re;
		}
		//检查该账号是否被注册了
		UsersDAO usersDAO = new UsersDAO();
		int id = usersDAO.findIdByAccount(account);
		if(id > 0){
			return re;
		}
		
		//检查账号有效性
		if(account == null || account.length() < 1){
			return re;
		}
		
		//将数据插入数据库
		MD5_Encoding md5 =new MD5_Encoding();
		re = usersDAO.insert(account,md5.getMD5ofStr(pass));
		
		return re;
	}

}
