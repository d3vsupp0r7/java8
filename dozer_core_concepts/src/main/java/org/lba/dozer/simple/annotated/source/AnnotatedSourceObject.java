package org.lba.dozer.simple.annotated.source;

import java.io.Serializable;

import org.dozer.Mapping;

public class AnnotatedSourceObject implements Serializable{

	private static final long serialVersionUID = -4163164564992029514L;
	
	private int id;
	
	// Direct Field level mapping
	@Mapping("sampleName")
	private String name;
	
	private String city;
	
	// Mapping happens directly as the destination bean has same field name.
	private String genericStringField;
	
	private String fieldOnlyOnSource;
	
	public AnnotatedSourceObject() {
		// Implement if necessary
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// Getter level mapping;
	// Automatic Type conversion happens from int to String
	@Mapping("primaryKey")
	public int getId() {
		return id;
	}

	public void setId(int age) {
		this.id = age;
	}

	public String getGenericStringField() {
		return genericStringField;
	}

	public void setGenericStringField(String genericStringField) {
		this.genericStringField = genericStringField;
	}

	public String getFieldOnlyOnSource() {
		return fieldOnlyOnSource;
	}

	public void setFieldOnlyOnSource(String fieldOnlyOnSource) {
		this.fieldOnlyOnSource = fieldOnlyOnSource;
	}

	@Override
	public String toString() {
		return "AnnotatedSourceObject [name=" + name + ", city=" + city + ", id=" + id + ", genericStringField="
				+ genericStringField + ", fieldOnlyOnSource=" + fieldOnlyOnSource + "]";
	}
	
}
