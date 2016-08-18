package com.verizon.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.verizon.dao.EmployeeDao;
import com.verizon.models.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	EmployeeDao dao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		dao = new EmployeeDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empId = request.getParameter("empId");
		String password = request.getParameter("pass");
		Employee e = dao.getEmployee(empId);
		HttpSession session = request.getSession();
		if(password.equals(e.getPassword()))
		{
			session.setAttribute("user",e);
			response.sendRedirect("Welcome.jsp");
		}
		else
		{
			response.sendRedirect("login.html");
		}
	}

}
