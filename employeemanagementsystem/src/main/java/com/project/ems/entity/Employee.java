package com.project.ems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="e_id")
	public long eId;
	
	@Column(name="name")
	public String name;
	
	@Column(name="dob")
	public long dob;
	
	@Column(name="salary")
	public long salary;
	
	@ManyToOne
	@JoinColumn
	public Department department;
	
	@Column(name="address")
	public String address;
	
	@Column(name="role")
	public String role;
	
	@Column(name="joining_date")
	public long joiningDate;
	
	@Column(name="yearly_bonus")
	public long yearlyBonus;
	
	@Column(name="reporting_manager")
	public Employee reportingManager;

	public long geteId() {
		return eId;
	}

	public void seteId(long eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDob() {
		return dob;
	}

	public void setDob(long dob) {
		this.dob = dob;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getJoiningDate() {
		return joiningDate;
	}

	public void setReportingManager(Employee reportingManager) {
		this.reportingManager = reportingManager;
	}

	public void setJoiningDate(long joiningDate) {
		this.joiningDate = joiningDate;
	}

	public long getYearlyBonus() {
		return yearlyBonus;
	}

	public void setYearlyBonus(long yearlyBonus) {
		this.yearlyBonus = yearlyBonus;
	}

	
	
}
