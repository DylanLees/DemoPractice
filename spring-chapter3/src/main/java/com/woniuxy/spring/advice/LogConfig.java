package com.woniuxy.spring.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ͨ��ע��ķ�ʽʵ�ֲ�����־��¼
 * 
 * @author Dylan
 *
 */
@Aspect // ��ʶ������һ�������ע��
public class LogConfig {
	// ����һ����̬�ĳ�Ա������������־��¼���ܡ�
	private static final Logger LOGGER = Logger.getLogger(LogConfig.class);

	/**
	 * �����е�
	 */
	@Pointcut("execution(* com.woniuxy.spring.service.impl.PayServiceImpl.*(..))") // ��ע�����ڱ�ʶ�÷�����һ���е�
	public void pointcut() {

	}

	/**
	 * �������棬����������е����ǿ ǰ����ǿ
	 */
	@Before(value = "pointcut()") // ��ע���ʶ�÷�����һ��ǰ����ǿ��value��ֵ���е�
	public void before() {
		System.err.println("�ڷ���ǰִ��");
	}

	/**
	 * ������ǿ
	 */
	@After(value = "pointcut()") // ��ע���ʶ�÷�����һ��������ǿ
	public void after() {
		System.err.println("�ڷ���֮��ִ��");
	}

	/**
	 * ������ǿ
	 */
	@Around(value = "pointcut()") // ��ע���ʶ�÷�����һ��������ǿ
	public Object around(ProceedingJoinPoint jointPoint) {// ProceedingJoinPoint������һ����ִ�е����ӵ����
		Object money = jointPoint.getArgs();// ��ȡ֧���Ľ������ӵ��д���˲����Ľ����
		try {
			// ��ȡ֧��֮��ķ��ؽ��
			Object result = jointPoint.proceed();
			if (result.equals("success")) {
				LOGGER.debug("֧����" + money + "֧�����" + result);

			} else {
				LOGGER.debug("֧��ʧ��");
			}
			return result;
		} catch (Throwable e) {
			// ֧���쳣
			LOGGER.debug("֧��ʧ��" + e.getMessage());
			return null;
		}

	}
}
