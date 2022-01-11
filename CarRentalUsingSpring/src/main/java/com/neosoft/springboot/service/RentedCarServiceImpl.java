package com.neosoft.springboot.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.bean.RentCarBean;
import com.neosoft.springboot.repo.RentCarRepository;

@Service
public class RentedCarServiceImpl implements RentedCarService{
	
	@Autowired
	private RentCarRepository rentCarRepo;
	
	@Override
	public void saveRentedCarData(RentCarBean rentCar) {
		rentCarRepo.save(rentCar);
	}
	
}
