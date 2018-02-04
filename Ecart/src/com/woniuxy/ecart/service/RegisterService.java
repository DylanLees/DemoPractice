package com.woniuxy.ecart.service;

import com.woniuxy.ecart.dao.PostInforDAO;
import com.woniuxy.ecart.dao.UserDAO;
import com.woniuxy.ecart.dao.po.RegisterPO;
import com.woniuxy.ecart.tools.MD5_Encoding;

/**
 * ����ҵ����߼��ж�
 * 
 * @author Administrator
 *
 */
public class RegisterService {
	/*
	 * �����û�ע����Ϣ���ķ���
	 */
	public boolean checkRegister(String userName, String password, String confirmPass, String contact, String tel,
			String mail, String address) {
		boolean re = false;// Ĭ��δע��
		// �ж��û�ע�������
		if (userName != null && userName.length() > 0 && userName.length() < 8 && password != null
				&& password.length() > 0 && password.length() < 10) {
			// ��֤��һ�����������͵ڶ�������������Ƿ�һ��
			if (password.equals(confirmPass)) {
				// ʵ����UserSe
				UserDAO dao = new UserDAO();
				// ����dao���������ͨ���û����ҵ�id
				int id = dao.findIdByUserName(userName);

				// �ж����ݿ����Ƿ���ڸ��û�
				if (id < 1) {
					// ʵ����RegisterPO
					RegisterPO rpo = new RegisterPO();
					// ��po���������Ԫ�ظ�ֵ
					rpo.setUserName(userName);
					rpo.setPassword(new MD5_Encoding().getMd5String(password));
					rpo.setContact(contact);
					rpo.setTel(tel);
					rpo.setMail(mail);
					rpo.setAddress(address);
					// ʵ����UserPO
					PostInforDAO pdao = new PostInforDAO();
					// ����һ��rpo�����pdao������������ݲ��뷽����������һ������ֵ
					re = pdao.pro_register(rpo);
				}
			}
		} else {
			System.out.println("�û��������벻����Ҫ��");
		}
		return re;
	}
}
