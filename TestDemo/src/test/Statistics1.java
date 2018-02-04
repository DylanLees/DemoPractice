package test;

import java.util.Scanner;

public class Statistics1 {
	public static void main(String[] args) {
		// 统计英文字母个数
		int letter = 0;
		// 统计数字个数
		int digit = 0;
		// 统计空格个数
		int space = 0;
		// 统计其他字符个数
		int other = 0;
		// 实例化扫描器
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入字符串：");
		// 获取输入的字符串
		String str = scanner.nextLine();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
				letter++;
			} else if (c >= '0' && c <= '9') {
				digit++;
			} else if (c == ' ') {
				space++;
			} else {
				other++;
			}
		}
		System.out.println("英文字母个数：" + letter);
		System.out.println("数字个数：" + digit);
		System.out.println("空格个数：" + space);
		System.out.println("其他字符个数：" + other);

	}
}
