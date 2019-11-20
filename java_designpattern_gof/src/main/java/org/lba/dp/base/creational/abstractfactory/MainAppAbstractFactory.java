package org.lba.dp.base.creational.abstractfactory;

public class MainAppAbstractFactory {

	public static void main(String[] args) {

		Client client = new Client();
		
		client.selectProduct(new ConcreteFactory());
		client.useAbstractFactory("UseOfAbstractFactory");
	}

}
