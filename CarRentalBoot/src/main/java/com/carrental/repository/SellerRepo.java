package com.carrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.carrental.entities.Car;

public interface SellerRepo extends JpaRepository<Car, Integer> {
	
	@Modifying
	@Query()
	public Car getCarById(int id);
}


