package com.woniuxy.mybatis.jdk;

/**
 * 定义一个类来实现Person接口中的购买商品的方法
 * 
 * @author Administrator
 *
 */
public class Bob implements Person {

	@Override
	public String buy(String name) {
		// 输出bob买东西
		System.out.println("李四  购买 " + name);
		return "成功";
	}

}
