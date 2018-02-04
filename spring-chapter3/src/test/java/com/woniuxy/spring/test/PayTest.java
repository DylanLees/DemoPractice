package com.woniuxy.spring.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.woniuxy.spring.service.PayService;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")//通过配置beans.xml文件方式执行测试功能时需要配置的信息
public class PayTest {
	//注入需要使用的接口
	@Resource
	private PayService payService;//通过Resource注入的对象只能是接口，不能是实现类。

	@Test
	public void pay() {
		//调用已经注入的接口中的支付方法
//		String point = payService.payByPoint(10020.21);
		String point = payService.payByDollar(10020.21);
		//打印积分支付结果
		System.err.println(point);

	}
}
