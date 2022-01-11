package com.neosoft.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.bean.CarBean;
import com.neosoft.springboot.repo.CarRepository;


@Service
public class CarServiceImpl implements CarService{
	@Autowired
	private CarRepository carRepo;

	@Override
	public void saveCar(CarBean car) {
		carRepo.save(car);
	}

	@Override
	public List<CarBean> getAllCars() {
		return carRepo.findAll();
	}

	@Override
	public void deleteCarById(long id) {
		carRepo.deleteById(id);
	}

	
	@Override
	public Page<CarBean> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.carRepo.findAll(pageable);
	}
	
}
