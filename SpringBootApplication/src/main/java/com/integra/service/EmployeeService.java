package com.integra.service;


import java.util.ArrayList;
import java.util.List;

import com.integra.dto.EmpCanteenRequest;
import com.integra.dto.EmployeeCanteenDetailsDto;
import com.integra.dto.EmployeeDto;
import com.integra.entity.EmployeeCanteenDetailsEntity;
import com.integra.entity.EmployeeEntity;
import com.integra.exception.CommonNullException;
import com.integra.exception.SaveDataException;

public interface EmployeeService {
	public EmployeeCanteenDetailsDto createCanteenEmployee( EmployeeCanteenDetailsDto employee_canteen_details)throws SaveDataException,CommonNullException;
	public List<EmployeeCanteenDetailsEntity> getCanteenEmployeesbyStatusCode(int id);
	public List<EmployeeCanteenDetailsEntity> updateEmployeeStatusCode(EmpCanteenRequest employee, int emp_Id);
	public ArrayList<EmployeeCanteenDetailsEntity> getCanteenFinance(EmployeeCanteenDetailsDto employee , int empId);
	public List<EmployeeCanteenDetailsEntity> getCanteenEmployeesbyEmployeeId(int id);
	public EmployeeEntity get_empdetails(int emp_id)throws SaveDataException,CommonNullException;
//--------------------------------------------------------------------------------------------------------------	
	public List<EmployeeCanteenDetailsEntity> filterEmployeesByMonthAndYear(
			List<EmployeeCanteenDetailsEntity> listUsers, int month, int year);
	 public List<EmployeeCanteenDetailsEntity> listAll();
	 
//	 ---------------------------------------------------------------------------------------------------
	public List<EmployeeDto> getEmployeeCanteenDetailsGrouped(int month, int year);
	public List<EmployeeDto> getHrData(int month, int year);
	public List<EmployeeCanteenDetailsEntity> getHrByEmpData(int emp_id, int month, int year);}
	