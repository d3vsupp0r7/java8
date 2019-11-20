package org.lba.dp.base.creational.builder;

public class Director {

	public Product construct(Builder builder) {
		
		builder.buildPart("Part 1");
		builder.buildPartAOfProduct("PartProductA");
		builder.buildPartBOfProduct("PartProductB");
		
		return builder.getResult();
	}
}
