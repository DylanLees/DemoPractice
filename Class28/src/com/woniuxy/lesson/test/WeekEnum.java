package com.woniuxy.lesson.test;

public enum WeekEnum {
	mon("星期一"),tue("星期二"),wed("星期三"),thu("星期四"),fri("星期五"),sat("星期六"),sun("星期天");
	private String name;
	//定义一个带参数的构造方法
	private WeekEnum(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
