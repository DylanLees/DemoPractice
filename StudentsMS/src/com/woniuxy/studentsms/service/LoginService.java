package com.woniuxy.studentsms.service;

import com.woniuxy.studentsms.dao.UsersDAO;
import com.woniuxy.studentsms.utils.MD5_Encoding;

public class LoginService {

	public boolean checkLogin(String userName, String userPass) {
		boolean re = false;// Ĭ�ϵ�¼ʧ��
		// ʵ��UserDAO�࣬�����������ͨ���û����ҵ�����ķ���
		UsersDAO usersDAO = new UsersDAO();
		String realPass = usersDAO.findUserNameByUserPass(userName);
		System.out.println(MD5_Encoding.MD5(userPass));
		// ���ݷ��ص�realPass�жϺ�ҳ������������Ƿ�һ�£����һ���򷵻�һ���жϽ��
		if (realPass.length() > 0 && MD5_Encoding.MD5(userPass).equals(realPass)) {
			re = true;// ��������ҵĽ����ֵΪtrue
		}
		return re;

	}

}
