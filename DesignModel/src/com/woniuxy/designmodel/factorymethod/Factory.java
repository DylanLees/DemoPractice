package com.woniuxy.designmodel.factorymethod;

/**
 * ������
 * 
 * @author Administrator
 *
 */
public class Factory {
	/**
	 * ������������ķ���
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
