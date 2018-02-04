package com.woniuxy.mybatis.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 生成代理对象
 * 
 * @author Administrator
 *
 */
public class ProxyFactory implements InvocationHandler {
	private Object target;// 目标对象

	/**
	 * 设置目标对象
	 * 
	 * @param target
	 */
	public void setTarget(Object target) {
		this.target = target;
	}

	/**
	 * 创建代理对象
	 * 
	 * @return
	 */
	public Object createProxy() {
		Class<? extends Object> clazz = target.getClass();// 获取目标对象的class对象

		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

	}

	/**
	 * invoke：回调函数
	 *  proxy：生成代理对象
	 *   method：调用的方法 
	 *   args：调用方法是传递的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("出国");
		Object invoke = method.invoke(target, args);
		System.out.println("邮寄");
		return invoke;
	}

}
