package com.woniuxy.studentsms.dao.po;
/**
 * ���ڴ洢�û���¼��Ϣ��ʧѪģ��
 * @author Administrator
 *
 */
public class UsersPO {
	private int id;//����
	private String userName;//�û���
	private String userPass;//�˺�
	private int flag;//��ɾ����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
