package test1;

import java.util.Date;

/**
 * 格式化日期
 * 
 * @author Administrator
 *
 */
public class DateTest {
public static void main(String[] args) {
	//获取当前时间，单位为毫秒
	Date date = new Date();
	System.out.println(String.format("%te", date));
	System.out.println(String.format("%tb", date));
	System.out.println(String.format("%tB", date));
	System.out.println(String.format("%tA", date));
	System.out.println(String.format("%ta", date));
	System.out.println(String.format("%tc", date));
	System.out.println(String.format("%tY", date));
	System.out.println(String.format("%tj", date));
	System.out.println(String.format("%tm", date));
	System.out.println(String.format("%td", date));
	System.out.println(String.format("%ty", date));
	System.out.println(String.format("%tH", date));
	System.out.println(String.format("%tI", date));
	System.out.println(String.format("%tk", date));
	System.out.println(String.format("%tl", date));
	System.out.println(String.format("%tM", date));
	System.out.println(String.format("%tS", date));
	System.out.println(String.format("%tL", date));
	System.out.println(String.format("%tN", date));
	System.out.println(String.format("%tp", date));
	System.out.println(String.format("%tz", date));
	System.out.println(String.format("%tZ", date));
	System.out.println(String.format("%ts", date));
	System.out.println(String.format("%tQ", date));
	System.out.println(String.format("%tF", date));
	System.out.println(String.format("%tD", date));
	System.out.println(String.format("%tc", date));
	System.out.println(String.format("%tr", date));
	System.out.println(String.format("%tT", date));
	System.out.println(String.format("%tR", date));
}
}
