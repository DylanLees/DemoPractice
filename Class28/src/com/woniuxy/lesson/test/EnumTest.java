package com.woniuxy.lesson.test;

import java.util.Scanner;

public class EnumTest {
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
//		System.out.println(WeekEnum.fri);
//		System.out.println(WeekEnum.values()[0].getName());//��ȡö�ٵ�ֵ
//		System.out.println(WeekEnum.fri.getName());
//		System.out.println(WeekEnum.values().length);//��ȡö�ٵĳ���
//		
//		System.out.println(WeekEnum.values());//����ö�ٵĵ�ַ
//		System.out.println(WeekEnum.mon.hashCode());
//		System.out.println(WeekEnum.mon.name());
//		System.out.println(WeekEnum.mon.compareTo(WeekEnum.fri));//�Ƚ�������ʵ������
//		System.out.println(WeekEnum.tue.ordinal());//��ȡʵ�����������±꣩
//		System.out.println(WeekEnum.mon.getDeclaringClass());//��ȡȫ�޶���
//		System.out.println(WeekEnum.values());//����ö�ٵ�����ֵ
//		for (WeekEnum weekEnum : WeekEnum.values()) {
//			System.out.println(weekEnum);
//		}
//		System.out.println(Computer.acer.getName());
//		for (Computer computer : Computer.values()) {
//			System.out.println(computer);
//		}
//		//��������Ĳ���ѡ��
//		System.out.println("��������Ĳ���ѡ��");
//		int key=sc.nextInt();
//		switch(key){
//		case 1:
//			System.out.println(WeekEnum.mon.getName());
//			break;
//		case 2:
//			System.out.println(WeekEnum.tue.getName());
//			break;
//		case 3:
//			System.out.println(WeekEnum.wed.getName());
//			break;
//		case 4:
//			System.out.println(WeekEnum.thu.getName());
//			break;
//		case 5:
//			System.out.println(WeekEnum.fri.getName());
//			break;
//		case 6:
//			System.out.println(WeekEnum.sat.getName());
//			break;
//		case 7:
//			System.out.println(WeekEnum.sun.getName());
//			break;
//		}
//		System.out.println("������1��7������");
//		int key= sc.nextInt();
//		System.out.println(WeekEnum.values()[key-1].getName());
		
		Person.male.setAge(20);
		Person.male.setBorn("20170203");
		Person.male.setName("����");
		Person.female.setAge(22);
		Person.female.setBorn("20170202");
		Person.female.setName("����");
//		System.out.println(Person.female.getSex());
//		System.out.println(Person.male.getSex());
		for (Person person : Person.values()) {
			System.out.println(person.getName()+person.getAge()+person.getSex()+person.getBorn());
		}
	}
}
