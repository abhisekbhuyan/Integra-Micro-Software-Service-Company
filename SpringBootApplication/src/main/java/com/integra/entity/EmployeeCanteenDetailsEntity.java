package com.integra.entity;

import java.io.Serializable;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "employee_canteen_details")
@Table(name="employee_canteen_details")
@Data
public class EmployeeCanteenDetailsEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2514867326546165461L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Emp_id")
	private int emp_id;
	
	@Column(name = "First_name")
	private String first_name;
	
	@Column(name = "Last_name")
	private String last_name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Created_date")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date created_date;
	
	@Column(name = "Created_by")
	private String created_by;
	
	@Column(name = "Modified_date")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date modified_date;
	
	@Column(name = "Modified_by")
	private String modified_by;
	
	@Column(name="Meal_amount")
	private Integer meal_amount;
	
	@Column(name="Status_code")
	private Integer status_code;
	
	@Column(name="total_amount")
	private Integer total_amount;
}
