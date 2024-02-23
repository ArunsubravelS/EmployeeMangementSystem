package com.project.ems.dto;
import java.io.Serializable;
import java.util.Date;

import com.project.ems.entity.Department;
import com.project.ems.entity.Employee;

public class DepartmentDto implements Serializable {
    private Long id;
    private String name;
    private Long creationDate;
    private Employee departmentHead;
    
    public DepartmentDto(Long id, String name, Long creationDate, Employee departmentHead) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.creationDate = creationDate;
    	this.departmentHead = departmentHead;
    }
    public DepartmentDto() {
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
	public Long getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}
	public Employee getDepartmentHead() {
		return departmentHead;
	}
	public void setDepartmentHead(Employee departmentHead) {
		this.departmentHead = departmentHead;
	}
	
	
    
}