package com.woniuxy.lesson.test;

public class GenericTest {
	public static void main(String[] args) {
		System.out.println(addInt(1,2));
		System.out.println(addFloat(1.1f,2.2f));
		System.out.println(addDouble(3,2));
		System.out.println(addLong(11,2));
		
		
	}
	public static <T> T add(T t1,T t2){
		return t2;
		
	}
	//定义一个泛型方法
	public static <T> int addInt(int t1,int t2){
		int t=t1+t2;
		return t;
	}
	public static <T> float addFloat(float t1,float t2){
		float t=t1+t2;
		return t;
	}
	public static <T>double addDouble(double t1,double t2){
		double t=t1+t2;
		return t;
	}
	public static <T>long addLong(long t1,long t2){
		long t=t1+t2;
		return t;
	}
}
