package com.verizon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.verizon.models.Employee;

public class EmployeeDao {
	Connection con;
	
	
	public EmployeeDao()
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","user1");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Employee getEmployee(String empId)
	{
		PreparedStatement pst;
		Employee employee=new Employee();
		try {
			pst = con.prepareStatement("select * from Employee_table where Emp_Id=?");
			pst.setString(1, empId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				employee.setEmpId(rs.getString(1));
				employee.setPassword(rs.getString(2));
				employee.setEmpName(rs.getString(3));
				employee.setEmpMId(rs.getString(4));
				employee.setEmail(rs.getString(5));
				employee.setLocation(rs.getString(6));
			}
			return employee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Employee> getAllEmployee()
	{
		ArrayList<Employee> list=new ArrayList<Employee>();
		Employee employee=new Employee();
		try {
			PreparedStatement pst =con.prepareStatement("Select * from employee_table");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				employee.setEmpId(rs.getString(1));
				employee.setPassword(rs.getString(2));
				employee.setEmpName(rs.getString(3));
				employee.setEmpMId(rs.getString(4));
				employee.setEmail(rs.getString(5));
				employee.setLocation(rs.getString(6));
				list.add(employee);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
