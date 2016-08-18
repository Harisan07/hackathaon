package com.verizon.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import com.verizon.dao.RequestDao;
import com.verizon.models.Employee;
import com.verizon.models.Request;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	RequestDao dao;
	Request request;
	Employee e;
	String pattern = "mm/dd/yyyy";
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Test");
		HttpSession session = request.getSession();
		Employee e = (Employee) session.getAttribute("user");
//		String name = request.getParameter("empId");
//		String fmLocation = request.getParameter("radio_210867_5");
		System.out.println(e.getLocation());
		String fmLocation = request.getParameter("fromlocation");
		System.out.println(fmLocation);

		if(e.getLocation().equals(fmLocation))
		{
		java.sql.Date fmDate;
		java.sql.Date toDate;
	
		    fmDate = (java.sql.Date.valueOf(request.getParameter("fmDate")));
			toDate = (java.sql.Date.valueOf(request.getParameter("toDate")));
			String toLocation = request.getParameter("tolocation");
			String empid = e.getEmpId();
			String mid = e.getEmpMId();
			dao.addRequest(empid, mid, fmDate, toDate, fmLocation, toLocation);
			response.sendRedirect("Welcome.jsp");
			

		
}
		else
		{
			response.sendRedirect("RequestRaiser.jsp");
		}
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new RequestDao();
		request = new Request();
		e = new Employee();
	}

}
