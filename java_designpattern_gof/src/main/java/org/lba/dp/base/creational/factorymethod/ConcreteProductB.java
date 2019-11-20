package org.lba.dp.base.creational.factorymethod;

public class ConcreteProductB implements Product{

	private String field;
	
	public ConcreteProductB() {
		// Implement if necessary
	}
	
	public ConcreteProductB(String field) {
		this.field = field;
	}

	@Override
	public void productBehavior(String param) {
		System.out.println("ConcreteProductB: productBehavior: " + param);
		
	}

	@Override
	public String toString() {
		return "ConcreteProductB [field=" + field + "]";
	}

}
