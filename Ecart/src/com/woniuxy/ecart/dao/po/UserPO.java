package com.woniuxy.ecart.dao.po;

/**
 * 存储用户信息
 * @author Administrator
 *
 */
public class UserPO {
	//定义成员变量
	private int id;//主键
	private String userName;//用户名
	private String password;//密码
	//定义setter和getter方法
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
