package org.lba.dp.base.creational.factorymethod;

public class ConcreteProduct implements Product{

	private String data;
	
	public ConcreteProduct() {
		// Implement if necessary
	}
	
	public ConcreteProduct(String data) {
		this.data = data;
	}

	@Override
	public void productBehavior(String param) {
		System.out.println("ConreteProduct: productBehavior: " + param);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ConcreteProduct [data=" + data + "]";
	}

}
