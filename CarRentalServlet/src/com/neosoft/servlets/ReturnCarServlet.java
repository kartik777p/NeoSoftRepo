package com.neosoft.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neosoft.dao.CarDao;
import com.neosoft.dao.CarDaoImpl;
@WebServlet("/ReturnCar")
public class ReturnCarServlet extends HttpServlet {
	private CarDao dao;
	//cons
	public ReturnCarServlet() {
		dao=new CarDaoImpl();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Return Book</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);
		pw.println("</head>");
		pw.println("<body>");
		request.getRequestDispatcher("navcustomer.html").include(request, response);
		
		pw.println("<div class='container'>");
		String callno=request.getParameter("carno");
		
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("id");
		
		int i=dao.returnCar(callno,id);
		if(i>0){
			pw.println("<h3>Hope You Enjoyed Your Ride...Thank you for Utilizing our Service!</h3>");
		}else{
			pw.println("<h3>Sorry, There is a some technical issue....</h3><p>Technical Error. Kindly visit later.</p>");
		}
		pw.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
	}

}
