package org.lba.comparator;

import java.io.Serializable;

public class SampleObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3780391456248685043L;
	private String name;
	private String status;
	private int sampleIntValue;
	private Boolean isValue;   
	
	public SampleObject() {
		// Implement if necessary
	}
	
	/**
	 * 
	 * @param name
	 * @param status
	 * @param sampleIntValue
	 */
	public SampleObject(String name, String status, int sampleIntValue) {
		super();
		this.name = name;
		this.status = status;
		this.sampleIntValue = sampleIntValue;
	}
	
	/**
	 * 
	 * @param name
	 * @param status
	 * @param sampleIntValue
	 * @param isValue
	 */
	public SampleObject(String name, String status, int sampleIntValue, Boolean isValue) {
		super();
		this.name = name;
		this.status = status;
		this.sampleIntValue = sampleIntValue;
		this.isValue = isValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSampleIntValue() {
		return sampleIntValue;
	}

	public void setSampleIntValue(int sampleIntValue) {
		this.sampleIntValue = sampleIntValue;
	}

	public Boolean getIsValue() {
		return isValue;
	}

	public void setIsValue(Boolean isValue) {
		this.isValue = isValue;
	}

	@Override
	public String toString() {
		return "SampleObject [name=" + name + ", status=" + status + ", sampleIntValue=" + sampleIntValue + ", isValue="
				+ isValue + "]";
	}
	
}
