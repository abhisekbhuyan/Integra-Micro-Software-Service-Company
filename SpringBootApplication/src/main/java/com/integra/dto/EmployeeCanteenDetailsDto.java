package com.integra.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeeCanteenDetailsDto {
	private Integer emp_id;
	private String first_name;
	private String last_name;
	private String email;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date created_date;
	private String created_by;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date modified_date;
	private String modified_by;
	private Integer meal_amount;
	private Integer status_code;
	private Integer total_amount;

}