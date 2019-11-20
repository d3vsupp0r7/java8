package org.lba.dp.base.creational.builder;

import java.io.Serializable;

public class PartAOfProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 801771554341968240L;
	
	private String propertyProductA;
	
	public PartAOfProduct() {
		//Implement if necessary
	}

	public String getPropertyProductA() {
		return propertyProductA;
	}

	public void setPropertyProductA(String propertyProductA) {
		this.propertyProductA = propertyProductA;
	}

	@Override
	public String toString() {
		return "PartAOfProduct [propertyProductA=" + propertyProductA + "]";
	}
	
	
}
