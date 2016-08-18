package com.verizon.models;


	public class Chennai {
		String empId;
		String bCode;		
		public Chennai() {
			super();
		}
		public Chennai(String empId, String bCode) {
			super();
			this.empId = empId;
			this.bCode = bCode;
		}
		public String getEmpId() {
			return empId;
		}
		public void setEmpId(String empId) {
			this.empId = empId;
		}
		public String getbCode() {
			return bCode;
		}
		public void setbCode(String bCode) {
			this.bCode = bCode;
		}
}
