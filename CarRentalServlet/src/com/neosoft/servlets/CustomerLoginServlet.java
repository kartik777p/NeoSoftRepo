package com.neosoft.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neosoft.dao.CustomerDao;
import com.neosoft.dao.CustomerDaoImpl;
@WebServlet("/CustomerLogin")
public class CustomerLoginServlet extends HttpServlet {
	private CustomerDao dao;
	//cons
	public CustomerLoginServlet() {
		dao=new CustomerDaoImpl();
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Customer</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);
		pw.println("</head>");
		pw.println("<body>");
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(dao.authenticate(email, password)){
			int id = dao.getId(email, password);

			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("email",email);
	
			request.getRequestDispatcher("navcustomer.html").include(request, response);
			request.getRequestDispatcher("cusotmercarousel.html").include(request, response);
			
		}else{
			request.getRequestDispatcher("navhome.html").include(request, response);
			pw.println("<div class='container'>");
			pw.println("<h3>Username or password error</h3>");
			request.getRequestDispatcher("customerloginform.html").include(request, response);
			pw.println("</div>");
		}
	
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
	}

}
