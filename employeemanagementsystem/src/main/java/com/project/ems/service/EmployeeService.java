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
import com.project.ems.repository.DepartmentRepository;
import com.project.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public void createEmployee(EmployeeDto eDto) {
		Employee emp = new Employee();
		Department dep = new Department();

		emp.setId(eDto.getId());
		emp.setDateOfBirth(eDto.getDateOfBirth());
		emp.setDepartment(eDto.getDepartment().toUpperCase());
		emp.setAddress(eDto.getAddress());
		emp.setJoiningDate(eDto.getJoiningDate());
		emp.setName(eDto.getName());
		emp.setRole(eDto.getRole().toUpperCase());
		emp.setSalary(eDto.getSalary());
		emp.setYearlyBonusPercentage(eDto.getYearlyBonusPercentage());

		emp.setReportingManager(eDto.getReportingManager());
		employeeRepository.save(emp);
	}

	public void addDepartment(DepartmentDto dDto) {
		Employee emp = new Employee();
		Department dep = new Department();
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
		dep.setDepartmentHead(emp);
		employeeRepository.save(emp);
		departmentRepository.save(dep);
	}

	public Employee updateEmp(Long id, EmployeeDto empDeatails) throws ResourceNotFoundException {
		Employee employe = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
		// Update employee details
		employe.setName(empDeatails.getName());
		employe.setDateOfBirth(empDeatails.getDateOfBirth());
		employe.setSalary(empDeatails.getSalary());
		employe.setDepartment(empDeatails.getDepartment());
		employe.setAddress(empDeatails.getAddress());
		employe.setJoiningDate(empDeatails.getJoiningDate());
		employe.setRole(employe.getRole());
		employe.setYearlyBonusPercentage(empDeatails.getYearlyBonusPercentage());
		employe.setReportingManager(employe);
		return employeeRepository.save(employe);

	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();

	}

	public Optional<Department> getEmployees(Long id) {
		return departmentRepository.findById(id);
	}

	public String deleteEmployee(Long id) throws ResourceNotFoundException, DepartmentNotEmptyException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: "));

		if (employee == null) {
			throw new DepartmentNotEmptyException("Department cannot be deleted as it contains employees.");
		} else {
			employeeRepository.delete(employee);
			return "deleted sucessfully";
		}
	}

	public List<Employee> getEmployeesByDepartmentId(Long id) {
		return employeeRepository.findEmployeeByDepartmentId(id);
	}

	public Department getDepartmentById(Long id) throws ResourceNotFoundException {
		return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with id:"));
	}

	public List<EmployeeDto> getEmployeeNameAndId() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> employeeDTOList = new ArrayList<>();

		for (Employee employee : employees) {
			EmployeeDto employeeDTO = new EmployeeDto();
			employeeDTO.setId(employee.getId());
			employeeDTO.setName(employee.getName());
			employeeDTOList.add(employeeDTO);
		}

		return employeeDTOList;
	}

	 
	public Employee updateEmployeeDepartment(Long employeeId, String department) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

		employee.setDepartment(department);
		return employeeRepository.save(employee);
	}
}