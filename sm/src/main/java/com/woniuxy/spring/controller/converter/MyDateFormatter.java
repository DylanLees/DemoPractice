package com.woniuxy.spring.controller.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class MyDateFormatter implements Formatter<Date> {
	// 定义想要转换的日期格式
	private static final DateFormat FORMATE = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 将响应的数据转换位String类型
	 */
	@Override
	public String print(Date object, Locale locale) {

		return FORMATE.format(object);
	}

	/**
	 * 将请求的数据转换位Date类型
	 */
	@Override
	public Date parse(String text, Locale locale) throws ParseException {

		return FORMATE.parse(text);
	}

}
