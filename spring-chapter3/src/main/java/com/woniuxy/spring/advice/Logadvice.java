package com.woniuxy.spring.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 实现操作日志的记录功能，该方法是通过配置bean.xml文件实现。
 * 
 * @author Dylan
 *
 */
public class Logadvice {
	// 定义记录日志信息的静态成员变量
	private static final Logger LOGGER = Logger.getLogger(Logadvice.class);

	/**
	 * 前置增强
	 */
	public void before() {
		System.err.println("在方法之前执行");
	}

	/**
	 * 后置增强
	 */
	public void after() {
		System.err.println("在方法之后执行");
	}

	/**
	 * 环绕增强
	 * 
	 * @return
	 */
	public Object around(ProceedingJoinPoint joinpoint) {// 环绕增强返回值的类型是一个Object对象。

		try {
			// 记录支付了多少钱
			Object money = joinpoint.getArgs()[0];
			//记录支付之后的结果，成功还是失败。
			Object result = joinpoint.proceed();
			if (result.equals("success")) {
				// 支付成功
				LOGGER.debug("支付了" + money + "结果：" + result);

			} else {
				LOGGER.debug("失败");
			}
			return result;

		} catch (Throwable e) {
			// 支付失败
			LOGGER.debug("支付失败" + e.getMessage());

		}
		return null;
	}

}
