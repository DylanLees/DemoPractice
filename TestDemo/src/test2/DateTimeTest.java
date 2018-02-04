package test2;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Calendar;

public class DateTimeTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();// 获取当前时间的一个实例对象
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)); // 0 - 11
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		System.out.println("************分割线*************");
		// Java 8
		LocalDateTime dt = LocalDateTime.now();// 获取当前时间的一个实例对象
		System.out.println(dt.getYear());
		System.out.println(dt.getMonthValue()); // 1 - 12
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.getHour());
		System.out.println(dt.getMinute());
		System.out.println(dt.getSecond());
		System.out.println("*************分割线1**********");
		long millis = cal.getTimeInMillis();// 获取毫秒数
		System.out.println(millis);
		long millis2 = Clock.systemDefaultZone().millis();// 获取毫秒数
		System.out.println(millis2);
		// 获取某月的最后一天
		int actualMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);// 获取当前月的最后一天
		System.out.println(actualMaximum);
	}

}
