package com.project.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ems.entity.Employee;

@Repository
public interface EMRepository extends JpaRepository<Employee, Long> {

	public void updateEmployee();

}
