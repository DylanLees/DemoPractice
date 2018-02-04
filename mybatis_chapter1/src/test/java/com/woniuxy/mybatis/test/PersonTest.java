package com.woniuxy.mybatis.test;

import com.woniuxy.mybatis.jdk.Bob;
import com.woniuxy.mybatis.jdk.Person;
import com.woniuxy.mybatis.jdk.ProxyFactory;

/**
 * 测试
 * 
 * @author Administrator
 *
 */
public class PersonTest {
	public static void main(String[] args) {
		// 保存动态生成的class文件
		System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		// 创建目标对象
		Bob bob = new Bob();
		// 找代购
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(bob);
		Person proxy = (Person) factory.createProxy();// 转换为Person接口
		String buy = proxy.buy("保时捷");// 方法调用会自动触发invoke方法调用
		System.out.println(buy);

	}
}
