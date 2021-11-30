package com.neosoft.beans;
//issuedbook
import java.sql.Date;

public class RentCar {
	private String carno, customerid, customername;
	private long customermobile;
	private Date renteddate;
	private String returnstatus;

	public RentCar() {
	}

	public RentCar(String carno, String customerid, String customername, long customermobile) {
		super();
		this.carno = carno;
		this.customerid = customerid;
		this.customername = customername;
		this.customermobile = customermobile;
	}

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

	public Date getRentedDate() {
		return renteddate;
	}

	public void setRentedDate(Date renteddate) {
		this.renteddate = renteddate;
	}

	public String getCarNo() {
		return carno;
	}

	public void setCarNo(String callno) {
		this.carno = callno;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public long getCustomermobile() {
		return customermobile;
	}

	public void setCustomermobile(long customermobile) {
		this.customermobile = customermobile;
	}

}
