package com.woniuxy.lesson.jdbc;

/**
 * ���ַ�����""��null������
 * @author Administrator
 *
 */
public class Test {
	    /**
	     * @param args
	     */
	    public static void main(String[] args) {        
	        String str1 = new String() ;
	        String str2 = null ;
	        String str3 = "" ;
	        System.out.println(str1==str2);                //�ڴ��ַ�ıȽϣ�����false
	        System.out.println(str1.equals(str2));         //ֵ�ıȽϣ�����false
	        System.out.println(str2==str3);                //�ڴ��ַ�ıȽϣ�����false
	        System.out.println(str3.equals(str2));         //ֵ�ıȽϣ�����false
	        System.out.println(str1==str3);                //�ڴ��ַ�ıȽϣ�����false
	        System.out.println(str1.equals(str3));         //ֵ�ıȽϣ�����true
	    }

	}

