package test1;

import java.util.Scanner;

public class GetCharNumber {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//统计英文字母
		int letter=0;
		//统计数字
		int digit=0;
		//统计空格
		int space=0;
		//统计其他字符
		int other=0;
		System.out.println("请输入需要统计的字符串");
		Scanner sc = new Scanner(System.in);
		//获取输入的字符串
		String str = sc.nextLine();//包括空格
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='a'&&c<='z'||c>='A'&&c<='Z'){
				letter++;
			}
			else if (c>='0'&&c<='9') {
				digit++;
			}
			else if (c==' ') {
				space++;
				
			}
			else {
				other++;
			}
		}
		System.out.println("letter\t"+letter);
		System.out.println("digit \t"+digit);
		System.out.println("space \t"+space);
		System.out.println("other \t"+other);
		
	}
}
