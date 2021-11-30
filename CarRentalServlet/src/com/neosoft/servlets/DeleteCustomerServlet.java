package com.neosoft.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.dao.CustomerDao;
import com.neosoft.dao.CustomerDaoImpl;
@WebServlet("/DeleteCustomer")
public class DeleteCustomerServlet extends HttpServlet {
	private CustomerDao dao;
	//cons
	public DeleteCustomerServlet() {
		dao=new CustomerDaoImpl();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		dao.delete(id);
		response.sendRedirect("ViewCustomer");
	}
}
