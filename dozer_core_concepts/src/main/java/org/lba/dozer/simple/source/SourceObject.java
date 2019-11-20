package org.lba.dozer.simple.source;

import java.io.Serializable;

public class SourceObject implements Serializable{

	private static final long serialVersionUID = -4163164564992029514L;
	
	private String name;
	private String city;
	private int age;
	
	public SourceObject() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "SourceObject [name=" + name + ", city=" + city + ", age=" + age + "]";
	}
	
}
