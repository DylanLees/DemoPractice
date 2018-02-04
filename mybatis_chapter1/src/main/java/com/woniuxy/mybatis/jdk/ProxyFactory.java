package com.woniuxy.mybatis.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ���ɴ������
 * 
 * @author Administrator
 *
 */
public class ProxyFactory implements InvocationHandler {
	private Object target;// Ŀ�����

	/**
	 * ����Ŀ�����
	 * 
	 * @param target
	 */
	public void setTarget(Object target) {
		this.target = target;
	}

	/**
	 * �����������
	 * 
	 * @return
	 */
	public Object createProxy() {
		Class<? extends Object> clazz = target.getClass();// ��ȡĿ������class����

		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

	}

	/**
	 * invoke���ص�����
	 *  proxy�����ɴ������
	 *   method�����õķ��� 
	 *   args�����÷����Ǵ��ݵĲ���
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("����");
		Object invoke = method.invoke(target, args);
		System.out.println("�ʼ�");
		return invoke;
	}

}
