package com.project.ems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ems.dto.DepartmentDto;
import com.project.ems.dto.EmployeeDto;
import com.project.ems.entity.Department;
import com.project.ems.entity.Employee;
import com.project.ems.exception.DepartmentNotEmptyException;
import com.project.ems.exception.ResourceNotFoundException;
import com.project.ems.service.EmsService;



@RestController
public class EmsController {
	
	@Autowired
	EmsService emsService;
	
	@PostMapping("/processCreateEmployee")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDto empDto) {
		emsService.createEmployee(empDto);
		return  ResponseEntity.ok("employee created successful");
		
	}
	
	@PostMapping("/processADD")
	public ResponseEntity<String> AddDepartment(@RequestBody DepartmentDto dDto){
		emsService.addDepartment(dDto);
		return ResponseEntity.ok("Sucessfully added");
		
	}
	
	@GetMapping("/")
	public String welcome() {
		
		return "welcome to ems";
	}
	
	
	@PutMapping("/processUpdateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto empDetails) throws ResourceNotFoundException {
	Employee updatedEmployee=emsService.updateEmp(id,empDetails);
	return ResponseEntity.ok(updatedEmployee);
	}
	
	@GetMapping("/getAllEmployess")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(emsService.getAllEmployees());
	}
	
	@GetMapping("/getAllDepartments")
	public ResponseEntity<List<Department>> getAllDepartments(){
		return ResponseEntity.ok(emsService.getAllDepartments());
	}
	
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id) throws ResourceNotFoundException, DepartmentNotEmptyException {
		return ResponseEntity.ok(emsService.deleteDepartment(id));
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException, DepartmentNotEmptyException {
		return ResponseEntity.ok(emsService.deleteEmployee(id));
	}
	
	@GetMapping("/departmentsexpand/{id}")
    public ResponseEntity<Department> getDepartmentWithEmployees(@PathVariable Long id, @RequestParam(required = false) boolean expand) throws ResourceNotFoundException {
        Department department = emsService.getDepartmentById(id);

		
//		  if (expand) { List<Employee> employees =
//		  emsService.getEmployeesByDepartmentId(id); department.setEmployee(employees);
//		  }
//		 
        return ResponseEntity.ok(department);
    }

	@GetMapping("/employeeslookup")
    public ResponseEntity<List<EmployeeDto>> listEmployeeNameAndId(@RequestParam(required = false) boolean lookup) {
        if (lookup) {
            List<EmployeeDto> employeeDTOList = emsService.getEmployeeNameAndId();
            return ResponseEntity.ok(employeeDTOList);
        } else {
            List<EmployeeDto> emptyList = new ArrayList<>();
            return ResponseEntity.ok(emptyList);
        }
    }
	@PostMapping("/updateDepartment")
	public ResponseEntity<String> updateDepartment(){
		return ResponseEntity.ok("updated sucessfully");
	}
	

}
