package com.project.ems.dto;

import com.project.ems.entity.Department;
import com.project.ems.entity.Employee;

public class DepartmentDto {
	
public long eId;
	
public long dId;

public String name;

public String creationDate;

public Employee departmentHead;



public long getdId() {
	return dId;
}

public void setdId(long dId) {
	this.dId = dId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCreationDate() {
	return creationDate;
}

public void setCreationDate(String creationDate) {
	this.creationDate = creationDate;
}

public Employee getDepartmentHead() {
	return departmentHead;
}

public void setDepartmentHead(Employee departmentHead) {
	this.departmentHead = departmentHead;
}




}
