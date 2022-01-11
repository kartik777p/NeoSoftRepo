package com.neosoft.springboot.repo;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neosoft.springboot.bean.CarBean;

import org.springframework.stereotype.Repository;
@Repository
public interface CarRepository extends JpaRepository<CarBean, Long>{
	List<CarBean> findByRented(String value);
	List<CarBean> findByCompanyNameLike(String name);
	List<CarBean> findByRentedAndCompanyNameContaining(String rentedValue, String companyname);
	
	@Transactional
	@Modifying
	@Query("update CarBean c set c.rented=:status where c.carno=:no")
	void updateRentedCarStatus(@Param("status") String status, @Param("no") long no);
	
	
	@Query("select c.rented from CarBean c where c.carno=:no")
	int getIsRented(@Param("no") int no);
	
}
