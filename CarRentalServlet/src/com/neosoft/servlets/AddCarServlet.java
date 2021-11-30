package com.neosoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.beans.Car;
import com.neosoft.dao.CarDao;
import com.neosoft.dao.CarDaoImpl;

@WebServlet("/AddCar")
public class AddCarServlet extends HttpServlet {
	private CarDao dao;
	//cons
	public AddCarServlet() {
		dao=new CarDaoImpl();
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Add Car Form</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>"+css);
		pw.println("<link rel='stylesheet' href='bootstrap.icons.css'/>");
		pw.println("</head>");
		pw.println("<body class='formPages'>");
		request.getRequestDispatcher("navadmin.html").include(request, response);
		
		pw.println("<div class='container'>");
		String carno=request.getParameter("carno");
		String name=request.getParameter("name");
		String model=request.getParameter("model");
		String syear=request.getParameter("year");
		String srentprice=request.getParameter("rentprice");
		int rentprice=Integer.parseInt(srentprice);
		int year=Integer.parseInt(syear);
		Car bean=new Car(carno,name,model,year,rentprice);
		int i=dao.save(bean);
		if(i>0){
			pw.println("<h3 class='text-center' style='color:red;'>    Car Added Sucessfully..............</h3>");
		}
		request.getRequestDispatcher("addcarform.html").include(request, response);
		pw.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
	}

}
