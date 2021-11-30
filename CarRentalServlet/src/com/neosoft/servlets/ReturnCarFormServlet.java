package com.neosoft.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neosoft.beans.RentCar;
import com.neosoft.dao.CarDao;
import com.neosoft.dao.CarDaoImpl;
@WebServlet("/ReturnCarForm")
public class ReturnCarFormServlet extends HttpServlet {
	private CarDao dao;
	//cons
	public ReturnCarFormServlet() {
		dao=new CarDaoImpl();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession s = request.getSession(false);
		if(s!=null) {
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Return Car Form</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);
		pw.println("</head>");
		pw.println("<body>");
		request.getRequestDispatcher("navcustomer.html").include(request, response);
		
//		out.println("<div class='container'>");
//		request.getRequestDispatcher("returnbookform.html").include(request, response);
//		out.println("</div>");
		
		pw.println("<div class='container'>");
		
		List<RentCar> list=dao.viewRentedCars();
		
		pw.println("<table class='table table-bordered table-striped'>");
		pw.println("<tr><th>Car No</th><th>Rented Date</th><th> Return Status </th><th>Return Car</th></tr>");
		for(RentCar bean:list){
			pw.println("<tr><td>"+bean.getCarNo()+"</td><td>"+bean.getRentedDate()+"</td><td>"+bean.getReturnstatus()+"</td><td><a href='ReturnCar?carno="+bean.getCarNo()+"'>Return Now</a></td></tr>");
		}
		pw.println("</table>");
		
		pw.println("</div>");
		

		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();}
		else {
			response.sendRedirect("AddCustomerForm");
		}
	}
}
