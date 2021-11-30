package com.neosoft.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.beans.RentCar;
import com.neosoft.dao.CarDao;
import com.neosoft.dao.CarDaoImpl;
@WebServlet("/ViewRentedCars")
public class ViewRentedCarsServlet extends HttpServlet {
	private CarDao dao;
	//cons
	public ViewRentedCarsServlet() {
		dao=new CarDaoImpl();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>View Rented Car</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);
		pw.println("</head>");
		pw.println("<body>");
		request.getRequestDispatcher("navadmin.html").include(request, response);
		
		pw.println("<div class='container'>");
		
		List<RentCar> list=dao.viewRentedCars();
		
		pw.println("<table class='table table-bordered table-striped'>");
		pw.println("<tr><th>Car No</th><th>Customer Id</th><th>Customer Name</th><th>Customer Mobile</th><th>Rented Date</th><th>Return Status</th></tr>");
		for(RentCar bean:list){
			pw.println("<tr><td>"+bean.getCarNo()+"</td><td>"+bean.getCustomerid()+"</td><td>"+bean.getCustomername()+"</td><td>"+bean.getCustomermobile()+"</td><td>"+bean.getRentedDate()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
		}
		pw.println("</table>");
		
		pw.println("</div>");
		
	
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
	}
}
