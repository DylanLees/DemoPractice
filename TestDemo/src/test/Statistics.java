package test;

import java.util.Scanner;

public class Statistics {
	public static void main(String[] args) {
		statistics();

	}

	public static void statistics() {
		// 统计字母
		int letter = 0;
		// 统计数字
		int digit = 0;
		// 统计空格
		int space = 0;
		// 其他字符
		int other = 0;
		// 请输入一个字符串
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个字符串:");
		// 获取输入的字符串
		String str = scanner.nextLine();// nextLine()方法可以获得带空格的字符串
		// 将字符串转换位一个字符数组
		char[] ch = str.toCharArray();
		// 循环字符数组
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 'a' && ch[i] <= 'z' || ch[i] >= 'A' && ch[i] <= 'Z') {
				letter++;// 统计字母个数
			} else if (ch[i] >= '0' && ch[i] <= '9') {
				digit++;// 统计数字个数
			} else if (ch[i] == ' ') {
				space++;// 统计空格个数
			} else {
				other++;// 统计其他字符个数
			}

		}
		System.out.println("英文字母有：" + letter+"个");
		System.out.println("数字有：" + digit+"个");
		System.out.println("空格有：" + space+"个");
		System.out.println("其他字符有：" + other+"个");

	}
}
