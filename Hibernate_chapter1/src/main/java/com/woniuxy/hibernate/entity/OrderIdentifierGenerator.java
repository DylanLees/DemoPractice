package com.woniuxy.hibernate.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdentifierGenerator implements IdentifierGenerator {
	// 定义一个时间格式
	private static final DateFormat FORMATE = new SimpleDateFormat("yyyyMMddHHmmss");

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		// 创建一个StringBuilder
		StringBuilder builder = new StringBuilder(FORMATE.format(new Date()));
		// 定义订单的格式
		builder.append(UUID.randomUUID().toString());
		// 返回生成的订单字符串
		return builder.toString();
	}

}
