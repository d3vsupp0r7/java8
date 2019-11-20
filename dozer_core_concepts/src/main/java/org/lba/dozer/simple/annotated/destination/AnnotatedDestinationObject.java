package org.lba.dozer.simple.annotated.destination;

import java.io.Serializable;

public class AnnotatedDestinationObject implements Serializable{

	private static final long serialVersionUID = 32203199987153025L;
	
	private String primaryKey;
	private String sampleName;
	private String city;
	private String postalCode;
	
	//
	private String genericStringField;
	
	//
	private String fieldOnlyOnDestination;

	public AnnotatedDestinationObject() {
		//Implement if necessary
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getGenericStringField() {
		return genericStringField;
	}

	public void setGenericStringField(String genericStringField) {
		this.genericStringField = genericStringField;
	}

	public String getFieldOnlyOnDestination() {
		return fieldOnlyOnDestination;
	}

	public void setFieldOnlyOnDestination(String fieldOnlyOnDestination) {
		this.fieldOnlyOnDestination = fieldOnlyOnDestination;
	}

	@Override
	public String toString() {
		return "AnnotatedDestinationObject [primaryKey=" + primaryKey + ", sampleName=" + sampleName + ", city=" + city
				+ ", postalCode=" + postalCode + ", genericStringField=" + genericStringField
				+ ", fieldOnlyOnDestination=" + fieldOnlyOnDestination + "]";
	}
	
	
	
}
