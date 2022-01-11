package com.carrental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrental.entities.Car;
import com.carrental.repository.SellerRepo;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	public SellerRepo sellerRepo;
	
	@Override
	public void addCar(Car car){
		
		Car i = sellerRepo.save(car);
		System.out.println(i);
	}
	
	@Override
	public List<Car> viewCars(){
		return sellerRepo.findAll();
	}
	
	@Override
	public Car getCarById(int id){
		Optional<Car> car = sellerRepo.findById(id);
		if(car.isPresent()) {
			return car.get();
		}
		return null;
	}
	
	public void deleteCarById(int id) {
		sellerRepo.deleteById(id);
	}
}
