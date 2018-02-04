package test;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static int method(int i) {
		int result = 0;
		switch (i) {
		case 1:
			result = result + i;
		case 2:
			result = result + i * 2;
		case 3:
			result = result + i * 3;

		}
		return result;

	}

	public static void divide(int a, int b) {
		try {
			int c = a / b;
			System.out.println(c);

		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			System.out.println("finally");
		}
	}

	public static void main(String[] args) {
		// //向上取整
		// long round = Math.round(11.5);
		// long round2 = Math.round(-11.5);
		// System.out.println(round);
		// System.out.println(round2);
		//
		// int i=12;
		// System.out.println(i+=i-=i*=i);
//		int i = method(2);
//		System.out.println(i);
//		System.out.println(5/2);
//		Map map=new HashMap();
//		map.put("test", Integer.valueOf("123"));
//		Integer var=(Integer)map.get("test");
//		Object obj=map.get("test");
//		Object obj=(Object)map.get("test");
//		String str=(String)map.get("test");
//		System.out.println(str);
//		System.out.println(6+6+"aa"+6+6);
//		divide(4, 0);
		String a="java";
		String b="java";
		String x="ja";
		String y="va";
		String c=x+y;
		System.out.println(a==b);
		System.out.println(a==c);
		
		

	}

}
