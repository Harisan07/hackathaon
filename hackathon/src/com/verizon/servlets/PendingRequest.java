package com.verizon.servlets;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class PendingRequest
 */
public class PendingRequest extends HttpServlet {
	RequestDao dao;
	ArrayList<Request> list;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		dao = new RequestDao();
		list = new ArrayList<>();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Employee e = (Employee)session.getAttribute("user");
		list = dao.getAllRequestManager(e.getEmpId());
		if(list==null)
		{
			response.sendRedirect("Welcome.jsp");
		}
		session.setAttribute("md", list);
		response.sendRedirect("PendingRequest.jsp");
	}

}
