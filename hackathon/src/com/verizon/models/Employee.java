package com.verizon.models;

public class Employee {
	String empId;
	String password;
	String empName;
	String empMId;
	String email;
	String location;
	
	public Employee() {
		super();
	}
	public Employee(String empId, String password, String empName,
			String empMId, String email, String location) {
		super();
		this.empId = empId;
		this.password = password;
		this.empName = empName;
		this.empMId = empMId;
		this.email = email;
		this.location = location;
	}
	
	
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpMId() {
		return empMId;
	}
	public void setEmpMId(String empMId) {
		this.empMId = empMId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
