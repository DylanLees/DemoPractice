package com.woniuxy.spring.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * ʵ�ֲ�����־�ļ�¼���ܣ��÷�����ͨ������bean.xml�ļ�ʵ�֡�
 * 
 * @author Dylan
 *
 */
public class Logadvice {
	// �����¼��־��Ϣ�ľ�̬��Ա����
	private static final Logger LOGGER = Logger.getLogger(Logadvice.class);

	/**
	 * ǰ����ǿ
	 */
	public void before() {
		System.err.println("�ڷ���֮ǰִ��");
	}

	/**
	 * ������ǿ
	 */
	public void after() {
		System.err.println("�ڷ���֮��ִ��");
	}

	/**
	 * ������ǿ
	 * 
	 * @return
	 */
	public Object around(ProceedingJoinPoint joinpoint) {// ������ǿ����ֵ��������һ��Object����

		try {
			// ��¼֧���˶���Ǯ
			Object money = joinpoint.getArgs()[0];
			//��¼֧��֮��Ľ�����ɹ�����ʧ�ܡ�
			Object result = joinpoint.proceed();
			if (result.equals("success")) {
				// ֧���ɹ�
				LOGGER.debug("֧����" + money + "�����" + result);

			} else {
				LOGGER.debug("ʧ��");
			}
			return result;

		} catch (Throwable e) {
			// ֧��ʧ��
			LOGGER.debug("֧��ʧ��" + e.getMessage());

		}
		return null;
	}

}
