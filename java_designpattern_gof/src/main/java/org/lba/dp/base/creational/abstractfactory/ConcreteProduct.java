package org.lba.dp.base.creational.abstractfactory;

public class ConcreteProduct implements AbstractProduct{

	public void productBehavior(String param) {
		System.out.println("Product use param: " + param);	

	}

}
