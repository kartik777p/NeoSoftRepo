package com.neosoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.neosoft.commons.DatabaseConnectivity;

public class AdminLoginDao {
	private static final String AUTHONNTICATE_ADMIN = "SELECT COUNT(*) FROM ADMIN_LOGIN WHERE USERNAME=? AND PASSWORD=?";

	public boolean adminAuthontication(String email, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			// get connection obj
			con = DatabaseConnectivity.getCon();
			// create Statement obj having Query as Precompile
			ps = con.prepareStatement(AUTHONNTICATE_ADMIN);
			// set values to query param
			ps.setString(1, email);
			ps.setString(2, password);
			// execute query
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} // catch
			// return
		if (rs != null)
			return true;
		else
			return false;
	}
}// class
