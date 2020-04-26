package org.lba.hk.opencsv.mapper;

public class OpenCSVArraySizeAndArrayElementsDataMapper {

	private String arraySize;
	private String arrayElements;
	
	public OpenCSVArraySizeAndArrayElementsDataMapper() {
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
		return "OpenCSVArraySizeAndArrayElementsDataMapper [arraySize=" + arraySize + ", arrayElements=" + arrayElements
				+ "]";
	}

}
