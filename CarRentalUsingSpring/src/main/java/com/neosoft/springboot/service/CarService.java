package com.neosoft.springboot.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.neosoft.springboot.bean.CarBean;



public interface CarService {
	void saveCar(CarBean car);
	List<CarBean> getAllCars();
	void deleteCarById(long id);
	Page<CarBean> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
}
