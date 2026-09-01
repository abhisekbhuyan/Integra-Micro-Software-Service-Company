package com.integra.repository;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.integra.entity.EmployeeCanteenDetailsEntity;

public interface EmployeeCanteenDetailsRepository extends JpaRepository<EmployeeCanteenDetailsEntity,Integer> {
	@Query("select employee from employee_canteen_details employee where employee.status_code =:id")
	List<EmployeeCanteenDetailsEntity> getByStatusCode(@Param("id") int status_code);
	
//	@Query("select employee from employee_canteen_details employee where employee.emp_id =:id")
//	List<EmployeeCanteenDetailsEntity> getByEmpId(@Param("id") int emp_id);
	
	@Query("select employee from employee_canteen_details employee where employee.emp_id =:id AND employee.status_code = :code")
	ArrayList<EmployeeCanteenDetailsEntity> performSearch(@Param("id") int id , @Param("code") int code);
	
	@Query("SELECT SUM(employee.meal_amount) FROM employee_canteen_details employee WHERE employee.status_code = :code")
    Integer totalAmount(@Param("code") int code);
	
	@Query("select employee from employee_canteen_details employee where employee.status_code =:statusCode AND MONTH(employee.created_date)=:month AND YEAR(employee.created_date)=:year")
	List<EmployeeCanteenDetailsEntity> getByStatusCodeTest(@Param("statusCode") int statusCode,@Param("month") int month,@Param("year") int year);
	
	@Query("select employee from employee_canteen_details employee where employee.status_code =0 AND employee.emp_id =:id AND MONTH(employee.created_date)=:month AND YEAR(employee.created_date)=:year")
	List<EmployeeCanteenDetailsEntity> checkForEmpIdAndStatus(@Param("id") int emp_id,@Param("month") int month,@Param("year") int year);

	
	@Query("select employee from employee_canteen_details employee where employee.emp_id =:empId AND MONTH(employee.created_date)=:month AND YEAR(employee.created_date)=:year")
	List<EmployeeCanteenDetailsEntity> getByEmp_Id(@Param("empId") int empId,@Param("month") int month,@Param("year") int year);

	@Query("select employee from employee_canteen_details employee where employee.emp_id =:empId")
	List<EmployeeCanteenDetailsEntity> getByEmployee_Id(@Param("empId") int empId);
}
