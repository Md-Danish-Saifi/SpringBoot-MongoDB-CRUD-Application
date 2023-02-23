package com.mongo.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("employee")
public class EmployeeModel {
	@Id
	String id;
	@Field(name = "name")
	String name;
	@Field(name = "designation")
	String designation;
	@Field(name = "email")
	String email;
	@Field(name = "password")
	String password;
	public EmployeeModel() {}
	
	public EmployeeModel(String id, String name, String designation, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.email = email;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
