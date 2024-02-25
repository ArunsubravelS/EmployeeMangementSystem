package com.project.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ems.dto.EmployeeDto;
import com.project.ems.dto.ReportingDto;
import com.project.ems.entity.Employee;
import com.project.ems.exception.ResourceNotFoundException;
import com.project.ems.repository.EmployeeRepository;

@Service
public class ReportingService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<ReportingDto> getReportingChain(Long userId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + userId));

        ReportingDto reportingDto = new ReportingDto();
        reportingDto.setEmployee(new EmployeeDto(employee));

        List<EmployeeDto> reportingChain = new ArrayList<>();
        Employee manager = employee.getReportingManager();

        // Find the reporting chain starting from the given employee's manager
        while (manager != null) {
            reportingChain.add(new EmployeeDto(manager));
            manager = manager.getReportingManager();
        }

        reportingDto.setReportingChain(reportingChain);

        return ResponseEntity.ok(reportingDto);
    }
}