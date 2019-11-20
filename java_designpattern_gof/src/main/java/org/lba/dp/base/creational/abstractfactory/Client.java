package org.lba.dp.base.creational.abstractfactory;

public class Client {

	private AbstractFactory abstractFactory;
	
	public void selectProduct(AbstractFactory anAbstractFactory) {
		abstractFactory = anAbstractFactory;
	}
	
	public void useAbstractFactory(String param) {
		
		AbstractProduct product = abstractFactory.createProduct();
		AbstractProductB productB = abstractFactory.createProductB();
		AbstractProductC productC = abstractFactory.createProductC();
		
		product.productBehavior(param);
		productB.productBBehavior(param);
		productC.productCBehavior(param);
				
	}
}
