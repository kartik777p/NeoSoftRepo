package com.neosoft.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neosoft.beans.Customer;
import com.neosoft.dao.CustomerDao;
import com.neosoft.dao.CustomerDaoImpl;
@WebServlet("/EditCustomerForm")
public class EditCustomerFormServlet extends HttpServlet {
	private CustomerDao dao;
	//cons
	public EditCustomerFormServlet() {
		dao=new CustomerDaoImpl();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Edit Customer Form</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);
		pw.println("</head>");
		pw.println("<body class='formPages'>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		pw.println("<div class='container'>");

		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		HttpSession s = request.getSession(false);
		s.setMaxInactiveInterval(10000);
		Customer bean=dao.viewById(id);
		
		pw.println("<div class='container-contact100'>");
		pw.println("<div class='wrap-contact100'>");
		pw.println("<form action='EditCustomer' method='post' class='contact100-form validate-form'>");
		pw.println("<span class='contact100-form-title'>");
		pw.println("Edit Customer");
		pw.println("</span>");
		pw.println("<label for='name1' class='label-input100'>Name</label>");
		pw.println("<div class='wrap-input100 rs1 validate-input'>");
		pw.println("<input type='hidden' name='id' value='"+bean.getId()+"'/>");
		
		pw.println("<input type='text' class='form-control' value='"+bean.getName()+"' name='name' id='name1' placeholder='Name' required/>");
		pw.println("<span class='focus-input100'></span>");
		pw.println("</div>");
		
		pw.println("<label for='email1' class='label-input100'>Email address</label>");
		pw.println("<div class='wrap-input100'>");
		pw.println("<input type='email' class='form-control' value='"+bean.getEmail()+"'  name='email' id='email1' placeholder='Email' required/>");
		pw.println("</div>");
		
		pw.println("<label for='password1' class='label-input100'>Password</label>");
		pw.println("<div class='wrap-input100'>");
		pw.println("<input type='password' class='form-control' value='"+bean.getPassword()+"'  name='password' id='password1' placeholder='Password' required/>");
		pw.println("</div>  ");
		
		pw.println("<label for='mobile1' class='label-input100'>Mobile Number</label>");
		pw.println("<div class='wrap-input100'>");
		pw.println("<input type='number' class='form-control' value='"+bean.getMobile()+"'  name='mobile' id='mobile1' placeholder='Mobile' required/>");
		pw.println("</div>");
		

		pw.println("<div class='container-contact100-form-btn'>");
		pw.println("<input type='submit' class='btn btn-success' value='Update Details'/>");

		pw.println("</div>");
		pw.println("</form>");
		
		pw.println("</div>");
		pw.println("</div>");

		pw.println("</div>");
		
		
		

		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
		
	}
}
