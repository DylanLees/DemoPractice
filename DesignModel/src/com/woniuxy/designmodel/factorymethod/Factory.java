package com.woniuxy.designmodel.factorymethod;

/**
 * 工厂类
 * 
 * @author Administrator
 *
 */
public class Factory {
	/**
	 * 定义生产宝马的方法
	 * 
	 * @return
	 */
	public BMW createBMW(int type) {
		switch (type) {
		case 230:
			return new BMW230();
		case 253:
			return new BMW253();
		default:
			break;
		}
		return null;
	}
}
