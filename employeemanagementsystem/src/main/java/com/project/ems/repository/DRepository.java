package com.project.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ems.entity.Department;

@Repository
public interface DRepository extends JpaRepository<Department, Long> {

	@Query(value="select name from department where d_id=:id",nativeQuery=true)
	public Department findDepartmentById(long id);
}
