package com.woniuxy.spring.service.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

import com.woniuxy.spring.service.PayService;

/**
 * 定义支付实现类去继承实现支付的接口并重写接口中相关的支付方法
 * 
 * @author Dylan
 *
 */
@Service("PayService")
public class PayServiceImpl implements PayService {
	//设置静态变量
	private static double totalDollar = 100000;//现金总额
	private static double totalPoint = 100000;//积分总额
	/**
	 * 重写父类通过现金支付方法
	 */
	@Override
	public String payByDollar(double money) {
		//将现金总额转换为能存放大数字的格式例如：BigDecimal
//		BigDecimal bigDecimal = new BigDecimal(totalDollar);
		BigDecimal bigDecimal = BigDecimal.valueOf(totalDollar);
		BigDecimal decimal = BigDecimal.valueOf(money);
		//进行判断，满足支付金额小于现金总额执行if条件中的语句。
		if (bigDecimal.subtract(decimal).compareTo(BigDecimal.ZERO) >= 0) {
			totalDollar = bigDecimal.subtract(decimal).doubleValue();
			System.err.println("余额为：" + totalDollar);
			//支付成功，返回一个字符串
			return "success";
		} else {
			//支付失败，返回fail字符串
			return "fail";
		}

	}
	/**
	 * 	重写父类通过积分支付方法
	 */
	@Override
	public String payByPoint(double money) {
		//将总的积分转换为BigDecimal格式
//		BigDecimal bigDecimal = new BigDecimal(totalPoint);
		BigDecimal bigDecimal = BigDecimal.valueOf(totalPoint);
		BigDecimal decimal = BigDecimal.valueOf(money);
		//进行判断，待支付积分是否小于总的积分，如果满足，执行if条件中的语句。
		if (bigDecimal.subtract(decimal).compareTo(BigDecimal.ZERO) >= 0) {
			totalPoint = bigDecimal.subtract(decimal).doubleValue();
			System.err.println("剩余积分为：" + totalPoint);
			//支付成功，返回success
			return "success";
		} else {
			//支付失败，返回fail
			return "fail";
		}

	}

}
