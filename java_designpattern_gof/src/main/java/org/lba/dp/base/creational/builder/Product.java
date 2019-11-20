package org.lba.dp.base.creational.builder;

public class Product {

	private String data;
	private PartAOfProduct partA;
	private PartBOfProduct partB;
	
	public Product() {
		partA = new PartAOfProduct();
		partB = new PartBOfProduct();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public PartAOfProduct getPartA() {
		return partA;
	}

	public void setPartA(PartAOfProduct partA) {
		this.partA = partA;
	}

	public PartBOfProduct getPartB() {
		return partB;
	}

	public void setPartB(PartBOfProduct partB) {
		this.partB = partB;
	}

	@Override
	public String toString() {
		return "Product [data=" + data + ", partA=" + partA + ", partB=" + partB + "]";
	}
	
	
}
