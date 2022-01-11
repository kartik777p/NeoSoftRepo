package com.carrental.service;

import java.util.List;
import java.util.Optional;

import com.carrental.entities.ProvidedCar;

public interface ProvideService {

	public int checkCar(String carno);
	public int checkCarExist(String carno);
	public int noOfIssuedCar(String carno);

	public void addProvideCar(int number, ProvidedCar providecar);
	public List<ProvidedCar> viewProvidedCars();
	public Optional<ProvidedCar> checkCustomer(String carno, String useremail);
	public void updateReturnDetails(int num, String returnStatus, String carno);
	public ProvidedCar searchByName(String username);

}
