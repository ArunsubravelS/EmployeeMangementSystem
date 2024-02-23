package com.project.ems.dto;

import java.util.List;

public class ReportingDto {
	
	private EmployeeDto employeeDTO;

	private List<EmployeeDto> subordinateDTOs;

	public ReportingDto() {
		super();
	}

	public ReportingDto(EmployeeDto employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

	public EmployeeDto getEmployeeDTO() {
		return employeeDTO;
	}

	public void setEmployeeDTO(EmployeeDto employeeDTO) {
		this.employeeDTO = employeeDTO;
	}

	public List<EmployeeDto> getSubordinateDTOs() {
		return subordinateDTOs;
	}

	public void setSubordinateDTOs(List<EmployeeDto> subordinateDTOs) {
		this.subordinateDTOs = subordinateDTOs;
	}
}
