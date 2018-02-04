package com.woniuxy.designmodel.factorymethod1;

public class Customer {

	public static void main(String[] args) {
		FactoryBMW230 factoryBMW230 = new FactoryBMW230();
		factoryBMW230.createBMW();
		FactoryBMW253 factoryBMW253 = new FactoryBMW253();
		factoryBMW253.createBMW();

	}
}
