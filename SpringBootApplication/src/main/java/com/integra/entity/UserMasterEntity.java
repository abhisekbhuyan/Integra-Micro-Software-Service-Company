package com.integra.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_master")
@Data
public class UserMasterEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empid;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    // Add other columns as needed

    public UserMasterEntity() {
        // Default constructor
    }

    public UserMasterEntity(String first_name, String last_name, String email) {
        this.firstname = first_name;
        this.lastname = last_name;
        this.email = email;
    }

    // Getters and setters
    public int getEmp_id() {
        return empid;
    }

    public void setEmp_id(int emp_id) {
        this.empid = emp_id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String first_name) {
        this.firstname = first_name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String last_name) {
        this.lastname = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Add other getters and setters as needed
}