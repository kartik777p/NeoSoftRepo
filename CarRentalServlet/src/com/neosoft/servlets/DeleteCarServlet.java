package com.neosoft.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.dao.CarDao;
import com.neosoft.dao.CarDaoImpl;
@WebServlet("/DeleteCar")
public class DeleteCarServlet extends HttpServlet {
	private CarDao dao;
	//cons
	public DeleteCarServlet() {
		dao=new CarDaoImpl();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.delete(request.getParameter("callno"));
		response.sendRedirect("ViewCars");
	}
}
