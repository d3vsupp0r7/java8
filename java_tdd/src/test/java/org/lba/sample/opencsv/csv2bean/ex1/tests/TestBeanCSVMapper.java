package org.lba.sample.opencsv.csv2bean.ex1.tests;

public class TestBeanCSVMapper {

	private String arraySize;
	private String arrayElements;
	
	public TestBeanCSVMapper() {
		// Implement if necessary
	}

	public String getArraySize() {
		return arraySize;
	}

	public void setArraySize(String arraySize) {
		this.arraySize = arraySize;
	}

	public String getArrayElements() {
		return arrayElements;
	}

	public void setArrayElements(String arrayElements) {
		this.arrayElements = arrayElements;
	}

	@Override
	public String toString() {
		return "TestBeanCSVMapper [arraySize=" + arraySize + ", arrayElements=" + arrayElements + "]";
	}
	
	
}
