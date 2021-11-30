package com.neosoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.beans.Customer;
import com.neosoft.commons.DatabaseConnectivity;

public class CustomerDaoImpl implements CustomerDao {

	private static final String SAVE_CUTOMER = "INSERT INTO CUSTOMER(NAME,EMAIL,PASSWORD,MOBILE,STATUS_FLAG) VALUES(?,?,?,?,?)";

	private static final String UPDATE_CUSTOMER = "UPDATE CUSTOMER SET NAME=?,EMAIL=?,PASSWORD=?,MOBILE=? WHERE ID=?";

	private static final String GET_ALL_CUSTOMERS = "SELECT ID,NAME,PASSWORD,EMAIL,MOBILE  FROM CUSTOMER WHERE STATUS_FLAG=1";
	private static final String GET_CUSTOMER_BY_ID = "SELECT * FROM CUSTOMER WHERE ID=?";
	private static final String DELETE_CUSTOMER_BY_ID = "UPDATE CUSTOMER SET STATUS_FLAG=0 WHERE ID=?";
	private static final String AUTHONTICATE_CUSTOMER = "SELECT * FROM CUSTOMER WHERE EMAIL=? AND PASSWORD=?";

	private static final String GET_USER_BY_ID_PASS = "SELECT ID FROM CUSTOMER WHERE EMAIL=? AND PASSWORD=?";

	public int save(Customer bean) {
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		System.out.println("CustomerDaoImpl.save()-start");
		try {
			con = DatabaseConnectivity.getCon();
			if (con != null) {
				ps = con.prepareStatement(SAVE_CUTOMER);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setString(1, bean.getName());
				ps.setString(2, bean.getEmail());
				ps.setString(3, bean.getPassword());
				ps.setLong(4, bean.getMobile());
				ps.setInt(5, 1);
				// execute query
				status = ps.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close ps
			try {
				if (ps != null) {
					ps.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally
		System.out.println("CustomerDaoImpl.save()-end");
		// return status
		return status;
	}

	public int update(Customer bean) {
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		System.out.println("CustomerDaoImpl.update()start");
		try {
			con = DatabaseConnectivity.getCon();
			if (con != null) {
				ps = con.prepareStatement(UPDATE_CUSTOMER);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setString(1, bean.getName());
				ps.setString(2, bean.getEmail());
				ps.setString(3, bean.getPassword());
				ps.setLong(4, bean.getMobile());
				ps.setInt(5, bean.getId());
				// execute query
				status = ps.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close ps
			try {
				if (ps != null) {
					ps.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally
		System.out.println("CustomerDaoImpl.update()end");
		// return status
		return status;
	}

	public List<Customer> view() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		System.out.println("CustomerDaoImpl.view()start");
		try {
			con = DatabaseConnectivity.getCon();
			if (con != null) {
				ps = con.prepareStatement(GET_ALL_CUSTOMERS);
			} // if
				// execute query
			if (ps != null) {
				rs = ps.executeQuery();
				// process the resultSet
				while (rs.next()) {
					Customer bean = new Customer();
					bean.setId(rs.getInt("id"));
					bean.setName(rs.getString("name"));
					bean.setEmail(rs.getString("email"));
					bean.setPassword(rs.getString("password"));
					bean.setMobile(rs.getLong("mobile"));
					list.add(bean);
				} // while
			} // if
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close rs
			try {
				if (rs != null) {
					rs.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (ps != null) {
					ps.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		}
		System.out.println("CustomerDaoImpl.view()end");
		// return list
		return list;
	}

	public Customer viewById(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer bean = new Customer();
		System.out.println("CustomerDaoImpl.viewById()start");
		try {
			con = DatabaseConnectivity.getCon();
			if (con != null) {
				ps = con.prepareStatement(GET_CUSTOMER_BY_ID);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setInt(1, id);
				rs = ps.executeQuery();
			} // if
			if (rs != null) {
				// process the resultSet
				if (rs.next()) {
					bean.setId(rs.getInt(1));
					bean.setName(rs.getString(2));
					bean.setPassword(rs.getString(3));
					bean.setEmail(rs.getString(4));
					bean.setMobile(rs.getLong(5));
				} // while
			} // if
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close rs
			try {
				if (rs != null) {
					rs.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (ps != null) {
					ps.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finlly
		System.out.println("CustomerDaoImpl.viewById()-end ");
		// return bean
		return bean;
	}

	public int delete(int id) {
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		System.out.println("CustomerDaoImpl.delete()start");
		try {
			con = DatabaseConnectivity.getCon();
			if (con != null) {
				ps = con.prepareStatement(DELETE_CUSTOMER_BY_ID);
			}
			// set values to query param
			if (ps != null) {
				ps.setInt(1, id);
				// execute query
				status = ps.executeUpdate();
			} // if
			System.out.println("status is:-" + status);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close ps
			try {
				if (ps != null) {
					ps.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finlly

		System.out.println("CustomerDaoImpl.delete()end");
		return status;
	}

	public boolean authenticate(String email, String password) {
		boolean status = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("CustomerDaoImpl.authenticate()start");
		try {
			con = DatabaseConnectivity.getCon();
			if (con != null) {
				ps = con.prepareStatement(AUTHONTICATE_CUSTOMER);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setString(1, email);
				ps.setString(2, password);
				// execute query
				rs = ps.executeQuery();
			} // if
				// process the resultSet
			if (rs != null) {
				if (rs.next()) {
					status = true;
				} // if
			} // if
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close rs
			try {
				if (rs != null) {
					rs.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (ps != null) {
					ps.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally
		System.out.println("CustomerDaoImpl.authenticate()end");
		return status;
	}

	public int getId(String email, String password) {
		int id = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("CustomerDaoImpl.getId()start");
		try {
			con = DatabaseConnectivity.getCon();
			if (con != null) {
				ps = con.prepareStatement(GET_USER_BY_ID_PASS);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setString(1, email);
				ps.setString(2, password);
				rs = ps.executeQuery();
			} // if
			if (rs != null) {
				if (rs.next()) {
					id = rs.getInt("id");
				} // if
			} // if
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close rs
			try {
				if (rs != null) {
					rs.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (ps != null) {
					ps.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close ps
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally
		System.out.println("CustomerDaoImpl.getId()end");
		return id;
	}
}// class
