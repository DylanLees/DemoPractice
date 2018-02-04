package com.woniuxy.spring.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.woniuxy.spring.advice.LogConfig;

/**
 * ͨ��ע��ķ�ʽʵ��֧����������־��¼
 * 
 * @author Dylan
 *
 */
@Configuration // ��ע�����ڱ�ʶ������Ϣ
@ComponentScan(basePackages = "com.woniuxy.spring.service.impl") // ɨ��֧����ʵ�������ڵİ�
@EnableAspectJAutoProxy // ��ע������ʹ�����ȡ�Զ�����
public class PayApplication {
	/**
	 * ʵ��֧����������־��¼
	 */
	@Bean // ��ע�����ڱ�ʶspring�е�bean����
	public LogConfig logConfig() {
		return new LogConfig();

	}
}
