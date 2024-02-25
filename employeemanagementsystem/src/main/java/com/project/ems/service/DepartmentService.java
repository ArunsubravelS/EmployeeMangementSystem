package com.project.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ems.dto.DepartmentDto;
import com.project.ems.entity.Department;
import com.project.ems.exception.DepartmentNotEmptyException;
import com.project.ems.exception.ResourceNotFoundException;
import com.project.ems.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department updateDepartment(Long id, DepartmentDto departmentDTO) throws ResourceNotFoundException {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
		department.setName(departmentDTO.getName());
		department.setCreationDate(departmentDTO.getCreationDate());
		department.setDepartmentHead(departmentDTO.getDepartmentHead());

		return departmentRepository.save(department);
	}
	
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	public String deleteDepartment(Long id) throws ResourceNotFoundException, DepartmentNotEmptyException {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id: "));

		if (department == null) {
			throw new DepartmentNotEmptyException("Department cannot be deleted as it contains employees.");
		} else {
			departmentRepository.delete(department);
			return "deleted sucessfully";
		}
	}

}
