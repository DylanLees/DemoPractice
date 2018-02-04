package test2;

import java.io.UnsupportedEncodingException;
/**
 * 编码格式转换
 * @author Administrator
 *
 */
public class Test2 {
	public static void main(String[] args) {
		String s1 = "你好";
		// s1.getBytes表示将字符串s1转换为字节流
		try {
			String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");// 将GB2312编码的字符串转换为8859
			System.out.println(s2);
			String s3 = new String(s2.getBytes("ISO-8859-1"), "GB2312");
			System.out.println(s3);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
