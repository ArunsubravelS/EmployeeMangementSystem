package com.project.ems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ems.dto.DepartmentDto;
import com.project.ems.dto.EmployeeDto;
import com.project.ems.dto.ReportingDto;
import com.project.ems.entity.Department;
import com.project.ems.entity.Employee;
import com.project.ems.exception.DepartmentNotEmptyException;
import com.project.ems.exception.ResourceNotFoundException;
import com.project.ems.service.DepartmentService;
import com.project.ems.service.EmployeeService;
import com.project.ems.service.PaginationService;
import com.project.ems.service.ReportingService;

@RestController
public class EmsController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	private PaginationService paginationService;

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ReportingService reportingService;
	
	@PostMapping("/processCreateEmployee")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDto empDto) {
		employeeService.createEmployee(empDto);
		return ResponseEntity.ok("employee created successful");

	}

	@PostMapping("/processADD")
	public ResponseEntity<String> AddDepartment(@RequestBody DepartmentDto dDto) {
		employeeService.addDepartment(dDto);
		return ResponseEntity.ok("Sucessfully department added");

	}



	@PutMapping("/processUpdateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto empDetails)
			throws ResourceNotFoundException {
		Employee updatedEmployee = employeeService.updateEmp(id, empDetails);
		return ResponseEntity.ok(updatedEmployee);
	}

	@GetMapping("/getAllEmployess")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@GetMapping("/getAllDepartments")
	public ResponseEntity<List<Department>> getAllDepartments() {
		return ResponseEntity.ok(departmentService.getAllDepartments());
	}

	@DeleteMapping("/departments/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id)
			throws ResourceNotFoundException, DepartmentNotEmptyException {
		return ResponseEntity.ok(departmentService.deleteDepartment(id));
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id)
			throws ResourceNotFoundException, DepartmentNotEmptyException {
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
	}

	@GetMapping("/departmentsexpand/{id}")
	public ResponseEntity<Department> getDepartmentWithEmployees(@PathVariable Long id,
			@RequestParam(required = false) boolean expand) throws ResourceNotFoundException {
		Department department = employeeService.getDepartmentById(id);
		return ResponseEntity.ok(department);
	}

	@GetMapping("/employeeslookup")
	public ResponseEntity<List<EmployeeDto>> listEmployeeNameAndId(@RequestParam(required = false) boolean lookup) {
		if (lookup) {
			List<EmployeeDto> employeeDTOList = employeeService.getEmployeeNameAndId();
			return ResponseEntity.ok(employeeDTOList);
		} else {
			List<EmployeeDto> emptyList = new ArrayList<>();
			return ResponseEntity.ok(emptyList);
		}
	}

	@PutMapping("/updateDepartment/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto departmentDTO)
			throws ResourceNotFoundException {
		Department updatedDepartment = departmentService.updateDepartment(id, departmentDTO);
		return ResponseEntity.ok(updatedDepartment);
	}

	@PutMapping("/employees/{employeeId}/{department}")
	public ResponseEntity<Employee> updateEmployeeDepartment(@PathVariable Long employeeId,
			@PathVariable String department) throws ResourceNotFoundException {
		Employee updatedEmployee = employeeService.updateEmployeeDepartment(employeeId, department);
		return ResponseEntity.ok(updatedEmployee);
	}

	@GetMapping("/employeesPagination")
	public ResponseEntity<Page<Employee>> getAllEmployees(@RequestParam(defaultValue = "0") int page) {
		List<Employee> allEmployees = employeeService.getAllEmployees();
		Page<Employee> employeePage = paginationService.getPage(allEmployees, page);

		return ResponseEntity.ok().header("X-Page", String.valueOf(employeePage.getNumber()))
				.header("X-Total-Pages", String.valueOf(employeePage.getTotalPages())).body(employeePage);
	}
	
	@GetMapping("/employees/{userId}/reporting")
    public ResponseEntity<ReportingDto> getReportingChain(@PathVariable Long userId) throws ResourceNotFoundException {
        return reportingService.getReportingChain(userId);
    }

}
