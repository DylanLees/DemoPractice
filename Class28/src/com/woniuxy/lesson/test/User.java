package com.woniuxy.lesson.test;

public class User {
	private String name;
	private int age;
	//无参数造方法
	public User(){
		
	}
	//带参数的构造方法
	public User(String name,int age){
		this.age=age;
		this.name=name;
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
	
	
	
	
}
