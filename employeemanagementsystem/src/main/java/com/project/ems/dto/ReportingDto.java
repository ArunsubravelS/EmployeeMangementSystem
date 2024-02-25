package com.project.ems.dto;

import java.util.List;

public class ReportingDto {
	
    private EmployeeDto employee;
    private List<EmployeeDto> reportingChain;

    // Constructors, getters, and setters

    public ReportingDto() {
    }

    public ReportingDto(EmployeeDto employee) {
        this.employee = employee;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public List<EmployeeDto> getReportingChain() {
        return reportingChain;
    }

    public void setReportingChain(List<EmployeeDto> reportingChain) {
        this.reportingChain = reportingChain;
    }
}
