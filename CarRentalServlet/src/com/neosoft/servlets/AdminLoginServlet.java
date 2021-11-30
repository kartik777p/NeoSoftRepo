package com.neosoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neosoft.dao.AdminLoginDao;

@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String css = "<link rel='stylesheet' href='css/style.css'>";
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.println("<head>");
		pw.println("<title>Admin Section</title>");
		pw.println("<link rel='stylesheet' href='bootstrap.min.css'/>" + css);
		//pw.println("<link rel='stylesheet' href='css/bootstrap.icons.css'/>");
		pw.println("</head>");
		pw.println("<body>");
      //gather values from req param 
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//use dao class here
		AdminLoginDao admlogin = new AdminLoginDao();
		//check email and password is valid or not 
		boolean count = admlogin.adminAuthontication(email, password);
		if (count != false) {
			//if valid create one session
			HttpSession session = request.getSession();
			session.setAttribute("admin", "true");
              //genrate one Dynamic page having header section and footer 
			request.getRequestDispatcher("navadmin.html").include(request, response);
			request.getRequestDispatcher("admincarousel.html").include(request, response);

		} else {
			//if not email and pass not correct show home page by giving err msg 
			request.getRequestDispatcher("navhome.html").include(request, response);
			pw.println("<div class='container' ");
			pw.println("<h3>Username or password error</h3><br>");
			request.getRequestDispatcher("adminloginform.html").include(request, response);
			pw.println("</div>");
		}
          //footer part
		request.getRequestDispatcher("footer.html").include(request, response);
		pw.close();
	}

}
