package org.lba.dp.base.creational.factorymethod;

public class ConcreteCreator extends Creator {

	@Override
	public Product createProductFactoryMethod() {
		return new ConcreteProduct();
	}

	@Override
	public Product createProductFactoryMethodWithParam(String param) {
		return  new ConcreteProduct(param);
	}

}
