package org.lba.model.employee.one2many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ForeignKeyAssoAccountEntity")
@Table(name = "ACCOUNT")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer accountId;

	@Column(name = "ACC_NUMBER", unique = true, nullable = false, length = 100)
	private String accountNumber;

	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private EmployeeO2M employee;

	public AccountEntity() {
		//Implement if necessary
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public EmployeeO2M getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeO2M employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountId=" + accountId + ", accountNumber=" + accountNumber + ", employee=" + employee
				+ "]";
	}
}
