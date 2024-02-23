package com.project.ems.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private Long dateOfBirth;

    @Column(name = "salary")
    private double salary;

    @Column(name = "department")
    private String department;

    @Column(name = "address")
    private String address;

    @Column(name = "role")
    private String role;

    @Column(name = "joining_date")
    private Long joiningDate;

    @Column(name = "yearly_bonus_percentage")
    private double yearlyBonusPercentage;

    @ManyToOne
    @JoinColumn(name = "reporting_manager_id")
    private Employee reportingManager;

    public Employee(Long id, String name, Long dateOfBirth, double salary, String department, String address,
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
    
    public Employee() {
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
