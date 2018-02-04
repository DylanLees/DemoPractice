package test2;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormateDate {
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");// 指定要格式化的格式
		Date date = new Date();// 获取当前日期
		String format = simpleDateFormat.format(date);// 调用simpleDateFormat对象的格式化方法formate()格式化日期
		System.out.println(format);
		// java 8提供的方式,指定格式化的日期格式
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		// 获取当前时间
		LocalDate now = LocalDate.now();
		String format2 = ofPattern.format(now);
		System.out.println(format2);

		System.out.println(LocalDateTime.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDate.now());
		System.out.println(Clock.systemDefaultZone());//打印当前系统时钟
	}
}
