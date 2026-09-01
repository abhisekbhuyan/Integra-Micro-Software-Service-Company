package com.integra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.integra.entity.EmployeeEntity;

@SuppressWarnings("unused")
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	
	@Query("select employee from employee_canteen_details employee where employee.emp_id =:emp_id")
	EmployeeEntity getByEmp_Id(@Param("emp_id") int emp_id);

	@Query("select emp_details from user_master emp_details where emp_details.emp_id =:emp_id")
	EmployeeEntity get_details_ById(int emp_id);

	
}