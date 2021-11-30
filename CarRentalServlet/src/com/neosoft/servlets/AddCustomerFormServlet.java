package com.neosoft.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddCustomerForm")
public class AddCustomerFormServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Add Customer Form</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);

		pw.println("</head>");
		pw.println("<body>");
		
		request.getRequestDispatcher("navhome.html").include(request, response);
		pw.println("<div class='container'>");
		request.getRequestDispatcher("addcustomerform.html").include(request, response);
		pw.println("</div>");
		
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
	}

}
