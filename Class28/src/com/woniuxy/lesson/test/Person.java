package com.woniuxy.lesson.test;

public enum Person {
	male("��"),female("Ů");
	private String name;
	private int age;
	private  String sex;
	private String born;
	//����������Ĺ��췽��
	Person(String sex){
		this.sex=sex;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getBorn() {
		return born;
	}
	public void setBorn(String born) {
		this.born = born;
	}
	
	
}
