package com.neosoft.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.beans.Customer;
import com.neosoft.dao.CustomerDao;
import com.neosoft.dao.CustomerDaoImpl;
@WebServlet("/AddCustomer")
public class AddCustomerServlet extends HttpServlet {
	private CustomerDao dao;
	//cons
	public AddCustomerServlet() {
		dao=new CustomerDaoImpl();
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Add Customer</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);


		pw.println("</head>");
		pw.println("<body>");

		request.getRequestDispatcher("navhome.html").include(request, response);
		pw.println("<div class='container'>");
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		Customer bean=new Customer(name, email, password, mobile);
		dao.save(bean);

		pw.print("<h4 class='text-center' style='color:green;'>Customer added successfully</h4>");
		request.getRequestDispatcher("addcustomerform.html").include(request, response);
		
		
		pw.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
	}

}
