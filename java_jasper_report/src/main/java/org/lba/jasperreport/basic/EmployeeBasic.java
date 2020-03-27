package org.lba.jasperreport.basic;

import java.io.Serializable;

public class EmployeeBasic implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2434718335820621654L;
	private int id;
	private String name;
	private String organization;
	private String designation;
	private int salary;
	
	public EmployeeBasic(int id, String name, String organization, String designation, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.designation = designation;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String role) {
		this.designation = role;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + organization + ", role=" + designation + ", salary="
				+ salary + "]";
	}

}
