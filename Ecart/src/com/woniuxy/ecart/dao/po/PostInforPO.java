package com.woniuxy.ecart.dao.po;

/**
 * 用户邮递信息失血模型
 * @author Administrator
 *
 */
public class PostInforPO {
	//定义成员变量
	private int id;//主键
	private int uid;//外键
	private String contact;//联系人
	private String tel;//电话
	private String mail;//邮件
	private String address;//地址
	//定义setter和getter方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
