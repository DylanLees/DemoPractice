package com.woniuxy.studentsms.dao.po;

/**
 * 用于存储学生信息的失血模型
 * @author Administrator
 *
 */
public class StudentsPO {
	private int id;//主键
	private String sname;//学生姓名
	private String sex;//性别
	private int age;//年龄
	private String major;//专业
	private int uid;//班级编号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
}
