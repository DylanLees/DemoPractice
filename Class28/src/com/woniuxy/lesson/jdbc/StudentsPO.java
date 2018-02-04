package com.woniuxy.lesson.jdbc;

public class StudentsPO {
	private int id;
	private String sname;
	private int age;
	private String sex;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "StudentsPO [id=" + id + ", sname=" + sname + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
