package com.woniuxy.lesson.test;

public enum WeekEnum {
	mon("����һ"),tue("���ڶ�"),wed("������"),thu("������"),fri("������"),sat("������"),sun("������");
	private String name;
	//����һ���������Ĺ��췽��
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
