package com.woniuxy.ecart.dao.po;

/**
 * 定义注册信息的失血模型
 * @author Administrator
 *
 */
public class RegisterPO {
	//定义成员变量
	private String userName;//用户名
	private String password;//密码
	private String contact;//联系人
	private String tel;//电话
	private String mail;//邮件
	private String address;//地址
	//定义setter和getter方法
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
