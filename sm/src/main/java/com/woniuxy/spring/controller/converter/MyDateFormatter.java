package com.woniuxy.spring.controller.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class MyDateFormatter implements Formatter<Date> {
	// ������Ҫת�������ڸ�ʽ
	private static final DateFormat FORMATE = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * ����Ӧ������ת��λString����
	 */
	@Override
	public String print(Date object, Locale locale) {

		return FORMATE.format(object);
	}

	/**
	 * �����������ת��λDate����
	 */
	@Override
	public Date parse(String text, Locale locale) throws ParseException {

		return FORMATE.parse(text);
	}

}
