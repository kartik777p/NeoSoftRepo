package com.neosoft.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.beans.Customer;
import com.neosoft.dao.CustomerDao;
import com.neosoft.dao.CustomerDaoImpl;
@WebServlet("/ViewCustomer")
public class ViewCustomerServlet extends HttpServlet {
	private CustomerDao dao;
	//cons
	public ViewCustomerServlet() {
		dao=new CustomerDaoImpl();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>View Customer</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);
		pw.println("</head>");
		pw.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		pw.println("<div class='container'>");
		
		List<Customer> list=dao.view();
		//pw.println("<lable> Search Box </lable>");
	pw.println("<input type='text'  name='search' >");
		pw.println("<table class='table table-bordered table-striped'>");
		pw.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>");
		for(Customer bean:list){
			pw.println("<tr><td >"+bean.getId()+"</td><td class='animals'>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getMobile()+"</td><td><a href='EditCustomerForm?id="+bean.getId()+"'>Edit</a></td><td><a href='DeleteCustomer?id="+bean.getId()+"'>Delete</a></td></tr>");
		}
		
		pw.println("</table>");
		
		pw.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
		
	}
}
