package org.lba.model.employee.one2one;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "EMPLOYEE_DETAIL")
public class EmployeeDetailEntity implements Serializable{

	private static final long serialVersionUID = -7964612731316339200L;

	@GenericGenerator(name = "generator", strategy = "foreign", 
			parameters = @Parameter(name = "property", value = "employee"))
			@Id
			@GeneratedValue(generator = "generator")
			@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "DETAIL_ONE")
	private String detailOne;
	
	@Column(name = "DETAIL_TWO")
	private String detailTwo;
	
	
	public EmployeeO2O employee;
	
	public EmployeeDetailEntity() {
		// Implement if necessary
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDetailOne() {
		return detailOne;
	}

	public void setDetailOne(String detailOne) {
		this.detailOne = detailOne;
	}

	public String getDetailTwo() {
		return detailTwo;
	}

	public void setDetailTwo(String detailTwo) {
		this.detailTwo = detailTwo;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public EmployeeO2O getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeO2O employee) {
		this.employee = employee;
	}
	
	
}
