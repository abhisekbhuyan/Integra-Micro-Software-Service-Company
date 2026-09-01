package com.integra.dto;



import lombok.Data;

@Data
public class EmployeeDto {
	
	private Integer emp_id;
	private String first_name;
	private String last_name;
	private String email;
	private int maxCount;
	private int total;
	

}