package com.carrental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrental.entities.ProvidedCar;
import com.carrental.repository.ProvideRepo;

@Service
public class ProvideServiceImpl implements ProvideService {

	@Autowired
	public ProvideRepo provideRepo;

	@Override
	public int checkCar(String carno) {
		System.out.println(carno);
		int status = provideRepo.checkCarNo(carno);
		System.out.println(status);
		return status;
	}

	@Override
	public void addProvideCar(int number, ProvidedCar providecar) {
		provideRepo.save(providecar);
		provideRepo.updateCarInfo(number, providecar.getCarno());
	}

	@Override
	public int checkCarExist(String carno) {
		return provideRepo.checkCarExist(carno);
	}

	@Override
	public int noOfIssuedCar(String carno) {
		return provideRepo.noOfIssuedCar(carno);
	}

	@Override
	public List<ProvidedCar> viewProvidedCars() {
		List<ProvidedCar> cars = provideRepo.findAll();
		return cars;
	}

	@Override
	public Optional<ProvidedCar> checkCustomer(String carno, String useremail) {
		return provideRepo.findByCarnoAndUseremail(carno, useremail);

	}

	@Override
	public void updateReturnDetails(int num, String returnStatus, String carno) {
		provideRepo.updateIssueCar(num, carno);
		provideRepo.updateReturnStatus(returnStatus, carno);

	}

	@Override
	public ProvidedCar searchByName(String username) {
		ProvidedCar details = provideRepo.findByUsername(username);
		System.out.println("details + " + details);
		return details;
	}

}
