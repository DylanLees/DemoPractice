package com.woniuxy.studentsms.dao.po;
/**
 * 用于存储用户登录信息的失血模型
 * @author Administrator
 *
 */
public class UsersPO {
	private int id;//主键
	private String userName;//用户名
	private String userPass;//账号
	private int flag;//软删除键
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
