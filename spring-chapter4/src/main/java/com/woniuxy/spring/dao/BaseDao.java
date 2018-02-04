package com.woniuxy.spring.dao;

public class BaseDao {
	public void save(){
		System.out.println(this.getClass().getSimpleName()+"--------save");
	}
	public void update() throws Exception{
		int i=8/0;
		System.out.println(i);
	}
}
