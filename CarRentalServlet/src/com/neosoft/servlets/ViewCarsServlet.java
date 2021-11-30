package com.neosoft.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.beans.Car;
import com.neosoft.dao.CarDao;
import com.neosoft.dao.CarDaoImpl;
@WebServlet("/ViewCars")
public class ViewCarsServlet extends HttpServlet {
	private CarDao dao;
	//cons
	public ViewCarsServlet() {
		dao=new CarDaoImpl();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>View Cars</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);
		pw.println("</head>");
		pw.println("<body>");
		request.getRequestDispatcher("navadmin.html").include(request, response);
		
		pw.println("<div class='container'>");
		
		List<Car> list=dao.view();
		
		pw.println("<table class='table table-bordered table-striped'>");
		pw.println("<tr><th>Car No</th><th>Company Name</th><th>Model</th><th>Year</th><th>Rent Price</th><th>Rented</th><th>Delete</th></tr>");
		String rented = ""; 
		for(Car bean:list){
			if(bean.getRented()==0) 
				rented = "No";
			else
				rented = "Yes";
			pw.println("<tr><td>"+bean.getCarno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getModel()+"</td><td>"+bean.getYear()+"</td><td>"+bean.getRentedPrice()+"</td><td>"+rented+"</td><td><a href='DeleteCar?callno="+bean.getCarno()+"'>Delete</a></td></tr>");
		}
		pw.println("</table>");
		
		pw.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
	}
}
