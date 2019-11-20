package org.lba.dp.base.creational.builder;

public abstract class Builder {
	
	public void buildPart(String param) {}
	
	public void buildPartAOfProduct(String param) {}
	
	public void buildPartBOfProduct(String param) {}
	
	public abstract Product getResult();
}
