package org.lba.dp.base.creational.abstractfactory;

public class ConcreteFactory implements AbstractFactory{

	public AbstractProduct createProduct() {
		
		return new ConcreteProduct();
	}

	public AbstractProductB createProductB() {
		return new ConcreteProductB();
	}

	public AbstractProductC createProductC() {

		return new ConcreteProductC();
	}

}
