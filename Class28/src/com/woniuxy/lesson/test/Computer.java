package com.woniuxy.lesson.test;

public enum Computer {
	dell("戴尔"),lenovo("联想"),acer("宏碁"),asua("华硕"),toshiba("东芝"),apple("苹果");
	
	private String name;
	//定义一个构造方法
	Computer(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
