package com.project.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ems.dto.DepartmentDto;
import com.project.ems.dto.EmployeeDto;
import com.project.ems.entity.Department;
import com.project.ems.entity.Employee;
import com.project.ems.repository.DRepository;
import com.project.ems.repository.EMRepository;

@Service
public class EmsService {

	@Autowired
	EMRepository emsRepo;

	@Autowired
	DRepository dRepo;

	public void createEmployee(EmployeeDto eDto) {
		Employee emp = new Employee();
		emp.seteId(eDto.geteId());
		emp.setName(eDto.getName());
		emp.setDob(eDto.getDob());
		emp.setAddress(eDto.getAddress());
		emp.setDepartment(eDto.getDepartment());
		emp.setJoiningDate(eDto.getJoiningDate());
		emp.setRole(eDto.getRole());
		emp.setReportingManager(eDto.getReportingManager());
		emp.setSalary(eDto.getSalary());
		emp.setYearlyBonus(eDto.getYearlyBonus());

		emsRepo.save(emp);
	}

	public void addDepartment(DepartmentDto dDto) {

		Department dep = new Department();
		dep.setdId(dDto.getdId());
		dep.setName(dDto.getName());
		dep.setDepartmentHead(dDto.getDepartmentHead());
		dep.setCreationDate(dDto.getCreationDate());
		
		dRepo.save(dep);
	}

}
