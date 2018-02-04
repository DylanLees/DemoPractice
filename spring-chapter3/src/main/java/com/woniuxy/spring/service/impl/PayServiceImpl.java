package com.woniuxy.spring.service.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

import com.woniuxy.spring.service.PayService;

/**
 * ����֧��ʵ����ȥ�̳�ʵ��֧���Ľӿڲ���д�ӿ�����ص�֧������
 * 
 * @author Dylan
 *
 */
@Service("PayService")
public class PayServiceImpl implements PayService {
	//���þ�̬����
	private static double totalDollar = 100000;//�ֽ��ܶ�
	private static double totalPoint = 100000;//�����ܶ�
	/**
	 * ��д����ͨ���ֽ�֧������
	 */
	@Override
	public String payByDollar(double money) {
		//���ֽ��ܶ�ת��Ϊ�ܴ�Ŵ����ֵĸ�ʽ���磺BigDecimal
//		BigDecimal bigDecimal = new BigDecimal(totalDollar);
		BigDecimal bigDecimal = BigDecimal.valueOf(totalDollar);
		BigDecimal decimal = BigDecimal.valueOf(money);
		//�����жϣ�����֧�����С���ֽ��ܶ�ִ��if�����е���䡣
		if (bigDecimal.subtract(decimal).compareTo(BigDecimal.ZERO) >= 0) {
			totalDollar = bigDecimal.subtract(decimal).doubleValue();
			System.err.println("���Ϊ��" + totalDollar);
			//֧���ɹ�������һ���ַ���
			return "success";
		} else {
			//֧��ʧ�ܣ�����fail�ַ���
			return "fail";
		}

	}
	/**
	 * 	��д����ͨ������֧������
	 */
	@Override
	public String payByPoint(double money) {
		//���ܵĻ���ת��ΪBigDecimal��ʽ
//		BigDecimal bigDecimal = new BigDecimal(totalPoint);
		BigDecimal bigDecimal = BigDecimal.valueOf(totalPoint);
		BigDecimal decimal = BigDecimal.valueOf(money);
		//�����жϣ���֧�������Ƿ�С���ܵĻ��֣�������㣬ִ��if�����е���䡣
		if (bigDecimal.subtract(decimal).compareTo(BigDecimal.ZERO) >= 0) {
			totalPoint = bigDecimal.subtract(decimal).doubleValue();
			System.err.println("ʣ�����Ϊ��" + totalPoint);
			//֧���ɹ�������success
			return "success";
		} else {
			//֧��ʧ�ܣ�����fail
			return "fail";
		}

	}

}
