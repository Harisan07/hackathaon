package com.verizon.models;

import java.sql.Date;

public class Request {
	int reqNo;
	String empId;
	String mId;
	java.util.Date fromDate;
	java.util.Date toDate;
	int status;
	String fromLocation;
	String toLocation;
	
	
	public Request() {
		super();
	}
	public Request(int reqNo, String empId, String mId, java.util.Date fromDate,
			java.util.Date toDate, int status, String fromLocation, String toLocation) {
		super();
		this.reqNo = reqNo;
		this.empId = empId;
		this.mId = mId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}
	public int getReqNo() {
		return reqNo;
	}
	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public java.util.Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}
	public java.util.Date getToDate() {
		return toDate;
	}
	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
}