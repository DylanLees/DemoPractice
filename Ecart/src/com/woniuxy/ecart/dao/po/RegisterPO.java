package com.woniuxy.ecart.dao.po;

/**
 * ����ע����Ϣ��ʧѪģ��
 * @author Administrator
 *
 */
public class RegisterPO {
	//�����Ա����
	private String userName;//�û���
	private String password;//����
	private String contact;//��ϵ��
	private String tel;//�绰
	private String mail;//�ʼ�
	private String address;//��ַ
	//����setter��getter����
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
