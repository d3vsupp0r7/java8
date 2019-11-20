package org.lba.model.employee.one2one;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_O2O")
public class EmployeeO2O implements Serializable{

	private static final long serialVersionUID = -7032504404104012814L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	public EmployeeDetailEntity employeeDetail;
	
	
	public EmployeeO2O() {
		// Implement if necessary
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public EmployeeDetailEntity getEmployeeDetail() {
		return employeeDetail;
	}


	public void setEmployeeDetail(EmployeeDetailEntity employeeDetail) {
		this.employeeDetail = employeeDetail;
	}


	@Override
	public String toString() {
		return "EmployeeO2O [id=" + id + ", name=" + name + ", surname=" + surname + ", employeeDetail="
				+ employeeDetail + "]";
	}
	
	
	
	
}
