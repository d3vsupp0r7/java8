package org.lba.dp.base.creational.builder;

public class MainAppBuilder {

	public static void main(String[] args) {

		Director director = new Director();
		
		Product result = director.construct(new ConcreteBuilder()); 
		
		System.out.println("Product built: " + result.toString());
		
	}

}
