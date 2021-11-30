package com.neosoft.beans;
//bookbean
public class Car {
	private String carno, companyname, model;
	private int year;
	private int rentedprice, rented;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Car(String carno, String companyname, String model, int year, int rentedprice) {
		super();
		this.carno = carno;
		this.companyname = companyname;
		this.model = model;
		this.year = year;
		this.rentedprice = rentedprice;
	}



	public String getCarno() {
		return carno;
	}

	public void setCarno(String callno) {
		this.carno = callno;
	}

	public String getName() {
		return companyname;
	}

	public void setName(String name) {
		this.companyname = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String author) {
		this.model = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRentedPrice() {
		return rentedprice;
	}

	public void setRentedPrice(int rentedPrice) {
		this.rentedprice = rentedPrice;
	}

	public int getRented() {
		return rented;
	}

	public void setRented(int rented) {
		this.rented = rented;
	}

}
