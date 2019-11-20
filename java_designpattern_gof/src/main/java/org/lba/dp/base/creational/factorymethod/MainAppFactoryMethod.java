package org.lba.dp.base.creational.factorymethod;

public class MainAppFactoryMethod {

	public static void main(String[] args) {
		
		ConcreteCreator concreteCreator = new ConcreteCreator();
		ConcreteCreatorB concreteCreatorB = new ConcreteCreatorB();
		
		ConcreteProduct concreteProduct;
		ConcreteProductB concreteProductB;
		
		concreteProduct = (ConcreteProduct) concreteCreator.createProductFactoryMethod();
		concreteProductB = (ConcreteProductB) concreteCreatorB.createProductFactoryMethod();
		
		System.out.println(""+concreteProduct.toString());
		System.out.println(""+concreteProductB.toString());
		
		concreteProduct = (ConcreteProduct) concreteCreator.createProductFactoryMethodWithParam("param for product");
		concreteProductB = (ConcreteProductB) concreteCreatorB.createProductFactoryMethodWithParam("param for productB");
		
		System.out.println(""+concreteProduct.toString());
		System.out.println(""+concreteProductB.toString());
	}
}
