package com.woniuxy.lesson.test;
/**
 * 1、创建一个失血模型
 * 2、创建一个Table注解
 * 3、创建一个Column注解
 * @author Administrator
 *
 */
@Table(name="users")
public class UserPO {
	@Column(name="id")
	 private int id;
	@Column(name="userPame")
	 private String userName;
	@Column(name="userPass")
	 private String userPass;
	@Column(name="role")
	 private int role;
	@Column(name="flag")
	 private int flag;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	 
}
