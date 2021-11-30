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

import com.neosoft.beans.Car;
import com.neosoft.dao.CarDao;
import com.neosoft.dao.CarDaoImpl;
@WebServlet("/RentCarForm")
public class RentCarFormServlet extends HttpServlet {
	private CarDao dao;
	//cons
	public RentCarFormServlet() {
		dao=new CarDaoImpl();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession s = request.getSession(false);
		if(s!=null){
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Rent Car</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);
		pw.println("</head>");
		pw.println("<body>");
		request.getRequestDispatcher("navcustomer.html").include(request, response);
		
		
		pw.println("<div class='container'>");
		
		List<Car> list=dao.viewAvailableCars();
		
		pw.println("<table class='table table-bordered table-striped'>");
		pw.println("<tr><th>Car No</th><th>Company Name</th><th>Model</th><th>Year</th><th>Rent Price</th><th>Booking Available</th></tr>");
		for(Car bean:list){
			pw.println("<tr><td>"+bean.getCarno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getModel()+"</td><td>"+bean.getYear()+"</td><td>"+bean.getRentedPrice()+"</td><td><a href='RentCar?carno="+bean.getCarno()+"'>Book Now</a></td></tr>");
		}
		pw.println("</table>");
		
		pw.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
		}else {
			response.sendRedirect("AddCustomerForm");
		}
	}
}
