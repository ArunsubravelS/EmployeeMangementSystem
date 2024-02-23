package com.project.ems.dto;
import java.io.Serializable;


import com.project.ems.entity.Employee;

public class EmployeeDto implements Serializable {
    private Long id;
    private String name;
    private Long dateOfBirth;
    private double salary;
    private String department;
    private String address;
    private String role;
    private Long joiningDate;
    private double yearlyBonusPercentage;
    private Employee reportingManager;
    
    
    public EmployeeDto(Long id, String name, Long dateOfBirth, double salary, String department, String address,
    		String role, Long joiningDate, double yearlyBonusPercentage, Employee reportingManager) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.dateOfBirth = dateOfBirth;
    	this.salary = salary;
    	this.department = department;
    	this.address = address;
    	this.role = role;
    	this.joiningDate = joiningDate;
    	this.yearlyBonusPercentage = yearlyBonusPercentage;
    	this.reportingManager = reportingManager;
    }
    public EmployeeDto() {
    	super();
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
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
	public Long getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Long joiningDate) {
		this.joiningDate = joiningDate;
	}
	public double getYearlyBonusPercentage() {
		return yearlyBonusPercentage;
	}
	public void setYearlyBonusPercentage(double yearlyBonusPercentage) {
		this.yearlyBonusPercentage = yearlyBonusPercentage;
	}
	public Employee getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(Employee reportingManager) {
		this.reportingManager = reportingManager;
	}
    
}