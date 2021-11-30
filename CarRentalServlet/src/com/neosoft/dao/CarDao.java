package com.neosoft.dao;

import java.util.List;

import com.neosoft.beans.Car;
import com.neosoft.beans.RentCar;

public interface CarDao {
  //save car 
	public  int save(Car bean);
	//viewCars
	public  List<Car> view();
	//check Available cars
	public  List<Car> viewAvailableCars();
	//delete car based on carNo
	public  int delete(String carno);
	//get rented
	public  int getRented(String carno);
	//get car on rent
	public  int rentCar(RentCar bean);
	// return car
	public  int returnCar(String carno,int customerid);
	//view rented Cars
	public  List<RentCar> viewRentedCars();
}
