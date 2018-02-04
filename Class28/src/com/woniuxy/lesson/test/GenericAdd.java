package com.woniuxy.lesson.test;

public class GenericAdd<T> {
	//add
	@SuppressWarnings("hiding")
	public <T extends Number,K extends Number> double add(T num1, K num2 ){
		return num1.doubleValue()+num2.doubleValue();
		
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		GenericAdd ga=new GenericAdd();
		System.out.println(ga.add(12l, 23l));
	}
	
	
	

}
