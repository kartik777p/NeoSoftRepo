package com.neosoft.commons;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectivity {
	public static Connection getCon() {
		Connection con = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_car2", "root", "root");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}//class
