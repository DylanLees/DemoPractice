package com.woniuxy.designmodel.factorymethod1;

public class FactoryBMW230 implements FactoryBMW {

	@Override
	public BMW230 createBMW() {
		// ��������230
		return new BMW230();
	}

}
