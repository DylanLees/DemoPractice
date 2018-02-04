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
	// ����һ��ʱ���ʽ
	private static final DateFormat FORMATE = new SimpleDateFormat("yyyyMMddHHmmss");

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		// ����һ��StringBuilder
		StringBuilder builder = new StringBuilder(FORMATE.format(new Date()));
		// ���嶩���ĸ�ʽ
		builder.append(UUID.randomUUID().toString());
		// �������ɵĶ����ַ���
		return builder.toString();
	}

}
