package com.carrental.service;

import java.util.List;

import com.carrental.entities.Car;

public interface SellerService {
	public void addCar(Car car);
	public List<Car> viewCars();
	public Car getCarById(int id);
	public void deleteCarById(int id);
}
