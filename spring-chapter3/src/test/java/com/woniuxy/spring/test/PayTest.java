package com.woniuxy.spring.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.woniuxy.spring.service.PayService;

/**
 * ������
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")//ͨ������beans.xml�ļ���ʽִ�в��Թ���ʱ��Ҫ���õ���Ϣ
public class PayTest {
	//ע����Ҫʹ�õĽӿ�
	@Resource
	private PayService payService;//ͨ��Resourceע��Ķ���ֻ���ǽӿڣ�������ʵ���ࡣ

	@Test
	public void pay() {
		//�����Ѿ�ע��Ľӿ��е�֧������
//		String point = payService.payByPoint(10020.21);
		String point = payService.payByDollar(10020.21);
		//��ӡ����֧�����
		System.err.println(point);

	}
}
