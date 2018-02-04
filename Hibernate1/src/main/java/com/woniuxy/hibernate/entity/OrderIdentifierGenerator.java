package com.woniuxy.hibernate.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdentifierGenerator implements IdentifierGenerator{
	//定义一个静态常量
	private static final DateFormat FORMAT=new SimpleDateFormat("YYYYMMDDHHMMSS");
	/*
	 * 自定义生成器
	 * @see org.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.spi.SessionImplementor, java.lang.Object)
	 */
	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		StringBuffer stringBuffer=new StringBuffer(FORMAT.format(new Date())) ;
		stringBuffer.append(UUID.randomUUID().toString());
		return stringBuffer.toString();
	}

}
