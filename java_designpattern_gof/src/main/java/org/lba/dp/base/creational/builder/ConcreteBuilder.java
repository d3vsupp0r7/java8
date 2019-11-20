package org.lba.dp.base.creational.builder;

public class ConcreteBuilder extends Builder {

	private Product product;
	
	public ConcreteBuilder() {
		product = new Product();
	}

	public ConcreteBuilder(Product product) {
		super();
		this.product = product;
	}

	@Override
	public void buildPart(String param) {
		product.setData(param);
	}
	
	@Override
	public void buildPartAOfProduct(String param) {
		product.getPartA().setPropertyProductA(param);
	}
	
	@Override
	public void buildPartBOfProduct(String param) {
		product.getPartB().setPropertyProductB(param);
	}
	
	@Override
	public Product getResult() {
		return product;
	}

}
