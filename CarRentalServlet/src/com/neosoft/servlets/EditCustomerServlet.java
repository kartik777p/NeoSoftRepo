package com.neosoft.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.beans.Customer;
import com.neosoft.dao.CustomerDao;
import com.neosoft.dao.CustomerDaoImpl;
@WebServlet("/EditCustomer")
public class EditCustomerServlet extends HttpServlet {
	private CustomerDao dao;
	//cons
	public EditCustomerServlet() {
		dao=new CustomerDaoImpl();
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		Customer bean=new Customer(id,name, email, password, mobile);
		dao.update(bean);
		response.sendRedirect("ViewCustomer");
	}

}
