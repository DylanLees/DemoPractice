package com.woniuxy.lesson.test;

public enum Computer {
	dell("����"),lenovo("����"),acer("�곞"),asua("��˶"),toshiba("��֥"),apple("ƻ��");
	
	private String name;
	//����һ�����췽��
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
