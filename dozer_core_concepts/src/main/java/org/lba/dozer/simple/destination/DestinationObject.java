package org.lba.dozer.simple.destination;

import java.io.Serializable;

public class DestinationObject implements Serializable{

	private static final long serialVersionUID = 32203199987153025L;
	
	private String fieldString1;
	private int fieldInt1;
	private String fieldString2;
	
	public DestinationObject() {
		// Implement if necessary
	}
	
	public String getFieldString1() {
		return fieldString1;
	}
	public void setFieldString1(String fieldString1) {
		this.fieldString1 = fieldString1;
	}
	public int getFieldInt1() {
		return fieldInt1;
	}
	public void setFieldInt1(int fieldInt1) {
		this.fieldInt1 = fieldInt1;
	}
	public String getFieldString2() {
		return fieldString2;
	}
	public void setFieldString2(String fieldString2) {
		this.fieldString2 = fieldString2;
	}

	@Override
	public String toString() {
		return "DestinationObject [fieldString1=" + fieldString1 + ", fieldInt1=" + fieldInt1 + ", fieldString2="
				+ fieldString2 + "]";
	}
	
}
