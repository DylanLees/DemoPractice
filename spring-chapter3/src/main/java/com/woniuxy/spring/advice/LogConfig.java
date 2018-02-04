package com.woniuxy.spring.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 通过注解的方式实现操作日志记录
 * 
 * @author Dylan
 *
 */
@Aspect // 标识该类是一个切面的注解
public class LogConfig {
	// 定义一个静态的成员变量，用于日志记录功能。
	private static final Logger LOGGER = Logger.getLogger(LogConfig.class);

	/**
	 * 定义切点
	 */
	@Pointcut("execution(* com.woniuxy.spring.service.impl.PayServiceImpl.*(..))") // 该注解用于标识该方法是一个切点
	public void pointcut() {

	}

	/**
	 * 定义切面，切面包含了切点和增强 前置增强
	 */
	@Before(value = "pointcut()") // 该注解标识该方法是一个前置增强，value的值是切点
	public void before() {
		System.err.println("在方法前执行");
	}

	/**
	 * 后置增强
	 */
	@After(value = "pointcut()") // 该注解标识该方法是一个后置增强
	public void after() {
		System.err.println("在方法之后执行");
	}

	/**
	 * 环绕增强
	 */
	@Around(value = "pointcut()") // 该注解标识该方法是一个环绕增强
	public Object around(ProceedingJoinPoint jointPoint) {// ProceedingJoinPoint，定义一个待执行的连接点对象。
		Object money = jointPoint.getArgs();// 获取支付的金额，即连接点中存放了操作的结果。
		try {
			// 获取支付之后的返回结果
			Object result = jointPoint.proceed();
			if (result.equals("success")) {
				LOGGER.debug("支付金额：" + money + "支付结果" + result);

			} else {
				LOGGER.debug("支付失败");
			}
			return result;
		} catch (Throwable e) {
			// 支付异常
			LOGGER.debug("支付失败" + e.getMessage());
			return null;
		}

	}
}
