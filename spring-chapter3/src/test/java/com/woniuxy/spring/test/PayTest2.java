package com.woniuxy.spring.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woniuxy.spring.application.PayApplication;
import com.woniuxy.spring.service.PayService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PayApplication.class) // ͨ��ע��ķ�ʽʵ��֧��������־��¼ʱ������ʹ�õķ���
public class PayTest2 {
	@Resource
	private PayService payService;// ͨ��Resourceע��ע����Ҫʹ�õĽӿ�
	/**
	 * �����ֽ�֧������
	 */
	@Test
	public void Pay() {
		// �����Ѿ�ע��Ľӿ�����Ҫʹ�õķ���
		String result = payService.payByDollar(100.02);
		System.err.println(result);
	}
}
