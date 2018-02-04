package com.woniuxy.ecart.service;

import com.woniuxy.ecart.dao.PostInforDAO;
import com.woniuxy.ecart.dao.UserDAO;
import com.woniuxy.ecart.dao.po.RegisterPO;
import com.woniuxy.ecart.tools.MD5_Encoding;

/**
 * 各种业务的逻辑判断
 * 
 * @author Administrator
 *
 */
public class RegisterService {
	/*
	 * 定义用户注册信息检查的方法
	 */
	public boolean checkRegister(String userName, String password, String confirmPass, String contact, String tel,
			String mail, String address) {
		boolean re = false;// 默认未注册
		// 判断用户注册的条件
		if (userName != null && userName.length() > 0 && userName.length() < 8 && password != null
				&& password.length() > 0 && password.length() < 10) {
			// 验证第一次输入的密码和第二次输入的密码是否一致
			if (password.equals(confirmPass)) {
				// 实例化UserSe
				UserDAO dao = new UserDAO();
				// 调用dao对象里面的通过用户名找到id
				int id = dao.findIdByUserName(userName);

				// 判断数据库中是否存在该用户
				if (id < 1) {
					// 实例化RegisterPO
					RegisterPO rpo = new RegisterPO();
					// 给po对象里面的元素赋值
					rpo.setUserName(userName);
					rpo.setPassword(new MD5_Encoding().getMd5String(password));
					rpo.setContact(contact);
					rpo.setTel(tel);
					rpo.setMail(mail);
					rpo.setAddress(address);
					// 实例化UserPO
					PostInforDAO pdao = new PostInforDAO();
					// 传递一个rpo对象给pdao对象里面的数据插入方法，并返回一个布尔值
					re = pdao.pro_register(rpo);
				}
			}
		} else {
			System.out.println("用户名或密码不符合要求");
		}
		return re;
	}
}
