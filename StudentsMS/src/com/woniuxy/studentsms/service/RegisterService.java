package com.woniuxy.studentsms.service;

import com.woniuxy.studentsms.dao.UsersDAO;
import com.woniuxy.studentsms.utils.MD5_Encoding;

public class RegisterService {

	public boolean checkRegister(String userName, String userPass, String confirmPass) {
		// ����һ��booleanֵ���ڽ����жϵĽ��
		boolean re = false;
		// �ж��û����Ƿ��Ѿ���ע��
		if(userPass.equals(confirmPass)&&userName.length()>0){
			UsersDAO dao = new UsersDAO();
			int id = dao.findIdByUserName(userName);
			if (id>0) {
				re = false;
			}
			//����ע���û����ݵķ���
			re=dao.insert(userName,MD5_Encoding.MD5(userPass));
			
		}
		
		return re;
	}
}
