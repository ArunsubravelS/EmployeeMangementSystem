package com.project.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ems.dto.DepartmentDto;
import com.project.ems.dto.EmployeeDto;
import com.project.ems.dto.ReportingDto;
import com.project.ems.entity.Department;
import com.project.ems.entity.Employee;
import com.project.ems.exception.DepartmentNotEmptyException;
import com.project.ems.exception.ResourceNotFoundException;
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
		Department dep=new Department();

		emp.setId(eDto.getId());
		emp.setDateOfBirth(eDto.getDateOfBirth());
		emp.setDepartment(eDto.getDepartment());
		emp.setAddress(eDto.getAddress());
		emp.setJoiningDate(eDto.getJoiningDate());
		emp.setName(eDto.getName());
		emp.setRole(eDto.getRole());
		emp.setSalary(eDto.getSalary());
		emp.setYearlyBonusPercentage(eDto.getYearlyBonusPercentage());
		
		
		emp.setReportingManager(eDto.getReportingManager());
		emsRepo.save(emp);
	}

	public void addDepartment(DepartmentDto dDto) {
		Employee emp=new Employee();
		Department dep = new Department();
//		Employee employee = new Employee();
//		BeanUtils.copyProperties(dDto.getDepartmentHead(), employee);
		dep.setId(dDto.getId());
		dep.setName(dDto.getName());
		dep.setCreationDate(dDto.getCreationDate());
		emp.setId(dDto.getDepartmentHead().getId());
		emp.setAddress(dDto.getDepartmentHead().getAddress());
		emp.setDateOfBirth(dDto.getDepartmentHead().getDateOfBirth());
		emp.setDepartment(dDto.getDepartmentHead().getDepartment());
		emp.setName(dDto.getDepartmentHead().getName());
		emp.setJoiningDate(dDto.getDepartmentHead().getJoiningDate());
		emp.setReportingManager(dDto.getDepartmentHead().getReportingManager());
		emp.setRole(dDto.getDepartmentHead().getRole());
		emp.setSalary(dDto.getDepartmentHead().getSalary());
		emp.setYearlyBonusPercentage(dDto.getDepartmentHead().getYearlyBonusPercentage());
		dep.setDepartmentHead(emp.getName());
		emsRepo.save(emp);
		dRepo.save(dep);
	}

	public void updateEmp() {

//		emsRepo.updateEmployee(name, eId);		
	}

	public List<Employee> getAllEmployees() {
		return emsRepo.findAll();

	}

	public List<Department> getAllDepartments() {
		return dRepo.findAll();
	}

	public Optional<Department> getEmployees(Long id) {
		return dRepo.findById(id);
	}

	public String deleteDepartment(Long id) throws ResourceNotFoundException, DepartmentNotEmptyException {
		Department department = dRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: "));

		if (department == null) {
			throw new DepartmentNotEmptyException("Department cannot be deleted as it contains employees.");
		} else {
			dRepo.delete(department);
			return "deleted";
		}
	}

//	public Department getDepartmentById(Long id) {
//		return dRepo.findDepartmentById(id);
//	}

	public List<Employee> getEmployeesByDepartmentId(Long id) {
		return emsRepo.findEmployeeByDepartmentId(id);
	}

//	public List<EmployeeDto> getEmployeeNameAndId() {
//		return emsRepo.findEmployeeNameAndId();
//	}
//	
	
	 public Department getDepartmentById(Long id) throws ResourceNotFoundException {
	        return dRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id:"));
	    }
	 
	 public List<EmployeeDto> getEmployeeNameAndId() {
	        List<Employee> employees = emsRepo.findAll();
	        List<EmployeeDto> employeeDTOList = new ArrayList<>();

	        for (Employee employee : employees) {
	            EmployeeDto employeeDTO = new EmployeeDto();
	            employeeDTO.setId(employee.getId());
	            employeeDTO.setName(employee.getName());
	            employeeDTOList.add(employeeDTO);
	        }

	        return employeeDTOList;
	    }
	 
	 
	 
//	 public ResponseEntity<ReportingDto> getReportingChain(Long userId) {
//	        EmployeeDto employee = emsRepo.findById(userId)
//	                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id:"));
//
//	        ReportingDto reportingDTO = new ReportingDto();
//	        reportingDTO.setEmployeeDTO(new EmployeeDto(employee));
//
//	        // Find all employees reporting to the given user
//	        List<Employee> subordinates = emsRepo.findByReportingManager(employee);
//	        List<EmployeeDto> subordinateDTOs = subordinates.stream()
//	                .map(EmployeeDto::new)
//	                .collect(Collectors.toList());
//
//	        reportingDTO.setSubordinateDTOs(subordinateDTOs);
//
//	        return ResponseEntity.ok(reportingDTO);
//	    }

}