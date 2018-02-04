package com.woniuxy.spring.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.woniuxy.spring.advice.LogConfig;

/**
 * 通过注解的方式实现支付操作的日志记录
 * 
 * @author Dylan
 *
 */
@Configuration // 该注解用于标识配置信息
@ComponentScan(basePackages = "com.woniuxy.spring.service.impl") // 扫描支付的实现类所在的包
@EnableAspectJAutoProxy // 该注解用于使切面获取自动代理
public class PayApplication {
	/**
	 * 实现支付操作的日志记录
	 */
	@Bean // 该注解用于标识spring中的bean对象
	public LogConfig logConfig() {
		return new LogConfig();

	}
}
