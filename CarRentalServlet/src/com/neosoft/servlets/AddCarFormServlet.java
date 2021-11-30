package com.neosoft.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AddCarForm")
public class AddCarFormServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession s = request.getSession(false);
		if(s!=null) {
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Add Car Form</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);
		pw.println("</head>");
		pw.println("<body class='formPages'>");
		request.getRequestDispatcher("navadmin.html").include(request, response);
		
		pw.println("<div class='container'>");
		request.getRequestDispatcher("addcarform.html").include(request, response);
		pw.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
		}else {
			response.sendRedirect("AdminLoginForm");
		}
	}

}
