package com.woniuxy.spring.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woniuxy.spring.application.PayApplication;
import com.woniuxy.spring.service.PayService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PayApplication.class) // 通过注解的方式实现支付操作日志记录时，测试使用的方法
public class PayTest2 {
	@Resource
	private PayService payService;// 通过Resource注解注入需要使用的接口
	/**
	 * 进行现金支付测试
	 */
	@Test
	public void Pay() {
		// 调用已经注入的接口中需要使用的方法
		String result = payService.payByDollar(100.02);
		System.err.println(result);
	}
}
