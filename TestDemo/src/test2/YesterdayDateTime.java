package test2;

import java.time.LocalDateTime;
import java.util.Calendar;

public class YesterdayDateTime {
	public static void main(String[] args) {
		// 打印昨天的当前时刻
		Calendar cal = Calendar.getInstance();// 获取一个日历的实例对象
		cal.add(Calendar.DATE, -1);// 获取昨天的时间
		System.out.println(cal.getTime());//获取时间点
		
		//java 8获取昨天的方法
		LocalDateTime today = LocalDateTime.now();//获取今天时间
		LocalDateTime yesterday=today.minusDays(1);
		System.out.println("昨天的当前时刻："+yesterday);
	}
}
