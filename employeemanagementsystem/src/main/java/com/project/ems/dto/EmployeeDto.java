package com.project.ems.dto;

import com.project.ems.entity.Department;
import com.project.ems.entity.Employee;

public class EmployeeDto {
	
	public long eId;
	
	public String name;
	
	public long dob;
	
	public long salary;
	
	public Department department;
	
	public String address;
	
	public String role;
	
	public long joiningDate;
	
	public long yearlyBonus;
	
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

	public void setJoiningDate(long joiningDate) {
		this.joiningDate = joiningDate;
	}

	public long getYearlyBonus() {
		return yearlyBonus;
	}

	public void setYearlyBonus(long yearlyBonus) {
		this.yearlyBonus = yearlyBonus;
	}

	public Employee getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(Employee reportingManager) {
		this.reportingManager = reportingManager;
	}
	
}
