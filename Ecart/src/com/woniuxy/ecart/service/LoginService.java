package com.woniuxy.ecart.service;

import com.woniuxy.ecart.dao.UserDAO;
import com.woniuxy.ecart.tools.MD5_Encoding;

public class LoginService {

	public boolean checkLogin(String userName, String password) {
		boolean re = false;// Ĭ��δ��¼
		// ʵ����UsersDAO��
		UserDAO user = new UserDAO();
		// ����user��������ͨ���˺Ų�ѯ����ķ���findPassByUserName()�������ز�ѯ���û�����
		String realpass = user.findPassByUserName(userName);
		// �жϴ�ҳ������������Ƿ�ʹ����ݿ��ѯ���������
		if (realpass.equals(new MD5_Encoding().getMd5String(password)) && password != null) {
			// ����һ��true�����booleanֵ
			re = true;
		}
		return re;
	}

}
