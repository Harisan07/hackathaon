package com.verizon.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.verizon.models.Request;

public class RequestDao {
	Connection con;
	static int reqNo=1;
	int dStatus=0;
	int nStatus=1;
	
	
	public RequestDao()
	{
		try {
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
	
	
	public boolean addRequest(String empId,String mId,Date fromDate,Date toDate,String fromLocation,String toLocation)
	{
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("insert into request values(?,?,?,?,?,?,?,?)");
			pst.setInt(1,reqNo);
			pst.setString(2,empId);
			pst.setString(3, mId);
			pst.setDate(4, fromDate);
			pst.setDate(5, toDate);
			pst.setString(6,fromLocation);
			pst.setString(7,toLocation);
			pst.setInt(8,dStatus);
			reqNo++;
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
	
	public boolean changeStatus(int reqNo)
	{
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("update request set status=? where request_no=?");
			pst.setInt(1,nStatus);
			pst.setInt(2,reqNo);
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
	
	
	public ArrayList<Request> getAllRequestManager(String mId)
	{
		Request request=new Request();
		ArrayList<Request> list=new ArrayList<Request>();
		try {
			PreparedStatement pst=con.prepareStatement("Select * from Request where manager_id=? and status=?");
			pst.setString(1, mId);
			pst.setInt(2, dStatus);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				request.setReqNo(rs.getInt(1));
				request.setEmpId(rs.getString(2));
				request.setmId(rs.getString(3));
				request.setFromDate(new java.util.Date(rs.getDate(4).getTime()));
				request.setToDate(new java.util.Date(rs.getDate(5).getTime()));
				request.setFromLocation(rs.getString(6));
				request.setToLocation(rs.getString(7));
				request.setStatus(rs.getInt(8));
				list.add(request);
			}
			if(list == null)
				return null;
			else
				return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
	
	
	public ArrayList<Request> getAllRequestEmployee(String empId)
	{
		Request request=new Request();
		ArrayList<Request> list=new ArrayList<Request>();
		try {
			PreparedStatement pst=con.prepareStatement("Select * from Request where emp_id=?");
			pst.setString(1, empId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				request.setReqNo(rs.getInt(1));
				request.setEmpId(rs.getString(2));
				request.setmId(rs.getString(3));
				request.setFromDate(new java.util.Date(rs.getDate(4).getTime()));
				request.setToDate(new java.util.Date(rs.getDate(5).getTime()));
				request.setFromLocation(rs.getString(6));
				request.setToLocation(rs.getString(7));
				request.setStatus(rs.getInt(8));
				list.add(request);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
}