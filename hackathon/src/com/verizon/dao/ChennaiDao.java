package com.verizon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.verizon.models.Chennai;
import com.verizon.models.Hyderabad;

public class ChennaiDao {
	Connection con;
	Chennai chennai;
	public ChennaiDao()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","user1");
			chennai=new Chennai();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Chennai deleteEmployee(String empId)
	{
		try {
			PreparedStatement pst=con.prepareStatement("select * from chn_table where emp_id=?");
			pst.setString(1, empId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				chennai.setEmpId(rs.getString(1));
				chennai.setbCode(rs.getString(2));
			}
			pst=con.prepareStatement("delete from chn_table where emp_id=?");
			pst.setString(1, empId);
			int ch=pst.executeUpdate();
			if(ch!=1)
			{
				return null;
			}
			return chennai;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addEmployee(Hyderabad obj)
	{
		try {
			PreparedStatement pst=con.prepareStatement("insert into chn_table values(?,?)");
			pst.setString(1, obj.getEmpId());
			pst.setString(2, obj.getbCode());
			int ch=pst.executeUpdate();
			if(ch==1)
			{
				return true;
			}
			else
			{
				return false;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}