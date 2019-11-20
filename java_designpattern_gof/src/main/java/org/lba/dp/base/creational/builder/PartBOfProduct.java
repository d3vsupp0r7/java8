package org.lba.dp.base.creational.builder;

import java.io.Serializable;

public class PartBOfProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1538615218153170167L;
	
	private String propertyProductB;
	
	public PartBOfProduct() {
		// Implement if necessary
	}

	public String getPropertyProductB() {
		return propertyProductB;
	}

	public void setPropertyProductB(String propertyProductB) {
		this.propertyProductB = propertyProductB;
	}

	@Override
	public String toString() {
		return "PartBOfProduct [propertyProductB=" + propertyProductB + "]";
	}
	
	
}
