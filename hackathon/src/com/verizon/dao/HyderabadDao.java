package com.verizon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.verizon.models.Chennai;
import com.verizon.models.Hyderabad;

public class HyderabadDao {
	Connection con;
	Hyderabad hyderabad;
	
	
	
	
	public HyderabadDao()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","user1");
			hyderabad=new Hyderabad();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Hyderabad deleteEmployee(String empId)
	{
		try {
			PreparedStatement pst=con.prepareStatement("select * from hyd_table where emp_id=?");
			pst.setString(1, empId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				hyderabad.setEmpId(rs.getString(1));
				hyderabad.setbCode(rs.getString(2));
			}
			pst=con.prepareStatement("delete from hyd_table where emp_id=?");
			pst.setString(1, empId);
			int ch=pst.executeUpdate();
			if(ch!=1)
			{
				return null;
			}
			return hyderabad;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public boolean addEmployee(Chennai obj)
	{
		try {
			PreparedStatement pst =con.prepareStatement("insert into hyd_table values(?,?)");
			pst.setString(1,obj.getEmpId());
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