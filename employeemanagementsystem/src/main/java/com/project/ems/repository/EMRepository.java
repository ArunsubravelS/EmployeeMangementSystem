package com.project.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ems.dto.EmployeeDto;
import com.project.ems.entity.Employee;

@Repository
public interface EMRepository extends JpaRepository<Employee, Long> {
	
	@Query(value="update employee set name=:name,role=:role where e_id=:eId",nativeQuery = true )
	public void updateEmployee(@RequestParam("name")String name,@RequestParam("eId")long eId);

	@Query(value="select name,e_id from employee",nativeQuery = true )
	public List<EmployeeDto> findEmployeeNameAndId();
	
	@Query(value="select name from employee where department_id=:id",nativeQuery=true)
	public List<Employee> findEmployeeByDepartmentId(long id);
	
	@Query(value="select * from employee",nativeQuery = true)
	public List<Employee> findByReportingManager(EmployeeDto employee);
	
}
