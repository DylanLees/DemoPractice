package test1;

import java.util.Scanner;

public class SwitchTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("请输入1~7的数字");
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		switch (key) {
		case 1:
			System.out.println("monday");
			break;
		case 2:
			System.out.println("tuesday");
			break;
		case 3:
			System.out.println("wensday");
			break;
		case 4:
			System.out.println("thursday");
			break;
		case 5:
			System.out.println("friday");
			break;
		case 6:
			System.out.println("saturday");
			break;
		case 7:
			System.out.println("sunday");
			break;

		default:
			System.out.println("输入的数字不符合要求");
			break;
		}
	}
}
