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
import com.verizon.models.Request;

/**
 * Servlet implementation class AcceptServlet
 */
public class AcceptServlet extends HttpServlet {
	RequestDao dao;
	Request request;
	ArrayList<Request> list;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		dao = new RequestDao();
		request = new Request();
		list = new ArrayList<Request>();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		list = (ArrayList<Request>)session.getAttribute("md");
		for(int i =0; i<list.size();i++)
		{
			int requestNo = Integer.parseInt(request.getParameter("responseNo"+i));
			dao.changeStatus(requestNo);
		}
		response.sendRedirect("Welcome.jsp");
	}

}
