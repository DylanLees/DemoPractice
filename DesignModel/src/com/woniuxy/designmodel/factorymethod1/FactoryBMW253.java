package com.woniuxy.designmodel.factorymethod1;

public class FactoryBMW253 implements FactoryBMW {

	@Override
	public BMW253 createBMW() {
		// ��������253
		return new BMW253();
	}

}
