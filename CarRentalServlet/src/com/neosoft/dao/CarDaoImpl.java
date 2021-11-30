package com.neosoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.beans.Car;
import com.neosoft.beans.RentCar;
import com.neosoft.commons.DatabaseConnectivity;

public class CarDaoImpl implements CarDao {
			private static final String SAVE_CAR = "INSERT INTO CAR_INFO VALUES(?,?,?,?,?,?,?)";
		
			private static final String VIEW_ALL_CARS = " SELECT CARNO,COMPANY_NAME,MODEL,YEAR,RENT_PRICE,RENTED FROM CAR_INFO WHERE STATUS_FLAG=? ";
		
			private static final String VIEW_AVAILABLE_CARS = "SELECT  * FROM CAR_INFO WHERE RENTED=? AND STATUS_FLAG=1";
		
			private static final String DELETE_CAR = "UPDATE  CAR_INFO SET STATUS_FLAG=0 WHERE CARNO=?";
		
			private static final String GET_RENTED_CAR_BASED_ON_ID = "SELECT * FROM CAR_INFO WHERE CARNO=? ";
		
			private static final String GET_CAR_ON_RENTED = "INSERT INTO RENT_CAR VALUES(?,?,?,?,?,?,?)";
		
			private static final String RETURN_CAR = "UPDATE RENT_CAR SET AVAILABLE='YES' WHERE CARNO=? AND CUSTOMERID=?";
		
			private static final String SET_RENTED_CAR = "UPDATE CAR_INFO SET RENTED=? WHERE CARNO=?";
		
			private static final String VIEW_RENTED_CARS = "SELECT * FROM RENT_CAR WHERE AVAILABLE=? ORDER BY RENTEDDATE DESC";

	/***************************************************************************************************************************/
	public int save(Car bean) {
		System.out.println("CarDaoImpl.save()-start");
		int status = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			// get connection obj
			con = DatabaseConnectivity.getCon();
			// create prepared st obj by making query as precompile query
			if (con != null) {
				ps = con.prepareStatement(SAVE_CAR);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setString(1, bean.getCarno());
				ps.setString(2, bean.getName());
				ps.setString(3, bean.getModel());
				ps.setInt(4, bean.getYear());
				ps.setInt(5, bean.getRentedPrice());
				ps.setInt(6, 0);
				ps.setInt(7,1);
				// execute insert query
				status = ps.executeUpdate();
				System.out.println("Status is:- "+status);
			} // if
				// con.close(); not good practice bcz if in above code exception is reised then
				// this line will not be executed and thats why connection will not be close

		} catch (SQLException se) { // knownException
			se.printStackTrace();
		} catch (Exception e) { // UnKnownException
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
				// close con
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally

		System.out.println("CarDaoImpl.save()-end");
		// return status
		return status;
	}

	/***************************************************************************************************************************/
	public List<Car> view() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		System.out.println("CarDaoImpl.view()Start");
		try {
			// get Connection obj
			con = DatabaseConnectivity.getCon();
			// create prepared st obj
			if (con != null) {
				ps = con.prepareStatement(VIEW_ALL_CARS);
			} // if
			if (ps != null) {
				//set values to query param
				ps.setInt(1,1);
				// execute select query
				rs = ps.executeQuery();
				// gather values from arrayList and Add to List
				while (rs.next()) {
					System.out.println("CarDaoImpl.view()while");
					Car bean = new Car();
					bean.setCarno(rs.getString("carno"));
					bean.setName(rs.getString("company_name"));
					bean.setModel(rs.getString("model"));
					bean.setYear(rs.getInt("year"));
					bean.setRentedPrice(rs.getInt("rent_price"));
					bean.setRented(rs.getInt("rented"));
					// add to arraylist
					list.add(bean);
				}
			} // if
		} catch (SQLException se) { // knownException
			se.printStackTrace();
		} catch (Exception e) { // unKnownException
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
				// close con
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally

		System.out.println("CarDaoImpl.view()End");
		return list;
	}

	/***************************************************************************************************************************/
	public List<Car> viewAvailableCars() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		System.out.println("CarDaoImpl.viewAvailableCars()Start");
		try {
			// get connection
			con = DatabaseConnectivity.getCon();
			// create ps statement
			if (con != null) {
				ps = con.prepareStatement(VIEW_AVAILABLE_CARS);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setInt(1, 0);
			} // if
				// execute query
			if (ps != null) {
				rs = ps.executeQuery();
				while (rs.next()) {
					Car bean = new Car();
					bean.setCarno(rs.getString("carno"));
					bean.setName(rs.getString("company_name"));
					bean.setModel(rs.getString("model"));
					bean.setYear(rs.getInt("year"));
					bean.setRentedPrice(rs.getInt("rent_price"));
					bean.setRented(rs.getInt("rented"));
					// add to list
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
				// close con
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally

		System.out.println("CarDaoImpl.viewAvailableCars()End");
		return list;
	}

	/***************************************************************************************************************************/
	public int delete(String carno) {
		Connection con = null;
		PreparedStatement ps = null;
		System.out.println("CarDaoImpl.delete()Start");
		int status = 0;
		try {
			// get connection obj
			con = DatabaseConnectivity.getCon();
			// create ps obj
			if (con != null) {
				ps = con.prepareStatement(DELETE_CAR);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setString(1, carno);
				// execute query
				status = ps.executeUpdate();
			} // if
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		} // catch
		finally {
			try {
				if (ps != null) {
					ps.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
				// close con
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally
		System.out.println("CarDaoImpl.delete()End");
		// return status
		return status;
	}

	/***************************************************************************************************************************/
	public int getRented(String carno) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("CarDaoImpl.getRented()Start");
		int issued = 0;
		try {
			// get connection obj
			con = DatabaseConnectivity.getCon();
			// get ps obj
			if (con != null) {
				ps = con.prepareStatement(GET_RENTED_CAR_BASED_ON_ID);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setString(1, carno);
				rs = ps.executeQuery();
			} // if
				// process resultSet
			if (rs != null) {
				if (rs.next()) {
					issued = rs.getInt("rented");
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
				// close con
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally
		System.out.println("CarDaoImpl.getRented()End");
		// return status
		return issued;
	}

	/***************************************************************************************************************************/
	public int rentCar(RentCar bean) {
		Connection con = null;
		PreparedStatement ps = null;
		System.out.println("CarDaoImpl.rentCar()Start");
		String callno = bean.getCarNo();
		int checkstatus = getRented(callno);
		System.out.println("Check status: " + checkstatus);
		if (checkstatus == 0) {
			int status = 0;
			try {
				// get connection obj
				con = DatabaseConnectivity.getCon();
				// create p obj
				if (con != null) {
					ps = con.prepareStatement(GET_CAR_ON_RENTED);
				} // if
					// set values to query param
				if (ps != null) {
					ps.setString(1, bean.getCarNo());
					ps.setString(2, bean.getCustomerid());
					ps.setString(3, bean.getCustomername());
					ps.setLong(4, bean.getCustomermobile());
					java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
					ps.setDate(5, currentDate);
					ps.setString(6, "no");
					ps.setInt(7, 0);
					// execute query
					status = ps.executeUpdate();
				} // if
				if (status > 0) {
					PreparedStatement ps2 = con.prepareStatement(SET_RENTED_CAR);
					ps2.setInt(1, 1);
					ps2.setString(2, callno);
					status = ps2.executeUpdate();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					if (ps != null) {
						ps.close();
					} // if
				} catch (SQLException se) {
					se.printStackTrace();
				} // catch
					// close con
				try {
					if (con != null) {
						con.close();
					} // if
				} catch (SQLException se) {
					se.printStackTrace();
				} // catch
			} // finally
			System.out.println("CarDaoImpl.rentCar()End");
			return status;
		} else {
			return 0;
		}
	}

	/***************************************************************************************************************************/
	public int returnCar(String carno, int customerid) {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		System.out.println("CarDaoImpl.returnCar()Start");
		int status = 0;
		try {
			// get connection obj
			con = DatabaseConnectivity.getCon();
			// create ps obj
			if (con != null) {
				ps = con.prepareStatement(RETURN_CAR);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setString(1, carno);
				ps.setInt(2, customerid);
				// execute query
				status = ps.executeUpdate();
			} // if
			if (status > 0) {
				// create ps obj
				if (con != null) {
					ps2 = con.prepareStatement(SET_RENTED_CAR);
				} // if
					// set values to query param
				if (ps2 != null) {
					ps2.setInt(1, 0);
					ps2.setString(2, carno);
					// execute query
					status = ps2.executeUpdate();
				} // IF
			} // if
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// close ps2
			try {
				if (ps2 != null) {
					ps2.close();
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
				// close con
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally
		System.out.println("CarDaoImpl.returnCar()end");
		// return status
		return status;
	}

	/***************************************************************************************************************************/
	public List<RentCar> viewRentedCars() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("CarDaoImpl.viewRentedCars()Start");
		List<RentCar> list = new ArrayList<RentCar>();
		try {
			// get con obj
			con = DatabaseConnectivity.getCon();
			// create ps obj
			if (con != null) {
				ps = con.prepareStatement(VIEW_RENTED_CARS);
			} // if
				// set values to query param
			if (ps != null) {
				ps.setString(1, "no");
				// execute query param
				rs = ps.executeQuery();
				while (rs.next()) {
					RentCar bean = new RentCar();
					bean.setCarNo(rs.getString("carno"));
					bean.setCustomerid(rs.getString("customerid"));
					bean.setCustomername(rs.getString("customername"));
					bean.setCustomermobile(rs.getLong("customermobile"));
					bean.setRentedDate(rs.getDate("renteddate"));
					bean.setReturnstatus(rs.getString("available"));
					// set to list
					list.add(bean);
				} // while
			} // if
				// con.close();
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
				// close con
			try {
				if (con != null) {
					con.close();
				} // if
			} catch (SQLException se) {
				se.printStackTrace();
			} // catch
		} // finally
		System.out.println("CarDaoImpl.viewRentedCars()End");
		// return list
		return list;
	}
}// Class
