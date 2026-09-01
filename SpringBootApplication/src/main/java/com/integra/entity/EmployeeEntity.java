package com.integra.entity;

import java.io.Serializable;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "user_master")
@Table(name="user_master")
@Data
public class EmployeeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2514867326546165461L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "emp_id")
	private Integer emp_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="created_date")
	private String created_date;
	
	@Column(name="role_id")
	private String role_id;
	
	@Column(name="company_code")
	private Integer company_code;
	
	@Column(name = "contact_no")
	private String contact_no;
	
	@Column(name="password")
	private String password;

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	public void UserMasterEntity(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }
	


	
	
}