
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
import com.neosoft.beans.RentCar;
import com.neosoft.dao.CarDao;
import com.neosoft.dao.CarDaoImpl;
import com.neosoft.dao.CustomerDao;
import com.neosoft.dao.CustomerDaoImpl;
@WebServlet("/RentCar")
public class RentCarServlet extends HttpServlet {
	private CustomerDao custDao;
	private CarDao cardao;
	//cons
	public RentCarServlet() {
		custDao=new CustomerDaoImpl();
		cardao=new CarDaoImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
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
		String carno=request.getParameter("carno");
		System.out.println(carno);
		
		HttpSession session = request.getSession(false);
		int id  = (int) session.getAttribute("id");
		Customer customer = custDao.viewById(id);
		
		RentCar bean=new RentCar(carno,String.valueOf(id),customer.getName(),customer.getMobile());
		int i=cardao.rentCar(bean);
		if(i>0){
			pw.println("<h3 class='text-center' style='color:red ;'>Thanks For booking..... You will get Car soon!</h3>");
		}else{
			pw.println("<h3 class='text-center' style='color:red;'>Sorry, unable to rent car.</h3><p>This car is already rented. Kindly visit later.</p>");
		}
		pw.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		
		pw.close();
	}

}
