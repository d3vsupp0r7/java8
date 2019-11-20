package org.lba.dp.base.creational.factorymethod;

public class ConcreteCreatorB extends Creator {

	@Override
	public Product createProductFactoryMethod() {
		
		return new ConcreteProductB();
	}

	@Override
	public Product createProductFactoryMethodWithParam(String param) {
		return new ConcreteProductB(param);
	}

}
