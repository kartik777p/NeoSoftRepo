package com.carrental.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carrental.entities.ProvidedCar;

public interface ProvideRepo extends JpaRepository<ProvidedCar, Integer> {

	@Query(value = "select count(no) from cardetail where no=:carno" ,nativeQuery=true)
	public int checkCarNo(String carno);
	
	@Query(value = "select noofcar from cardetail where no=:carno" ,nativeQuery=true)
	public int checkCarExist(String carno);
	
	@Query(value = "select issued from cardetail where no=:carno" ,nativeQuery=true)
	public int noOfIssuedCar(String carno);
	
	@Modifying
	@Transactional
	@Query(value = "update cardetail set issued=:number where no=:carno", nativeQuery=true)
	public void updateCarInfo(@Param("number") int number, @Param("carno") String carno);

	public Optional<ProvidedCar> findByCarnoAndUseremail(String carno, String useremail);
	
	@Modifying
	@Transactional
	@Query(value = "update cardetail set issued=:number where no=:carno", nativeQuery=true)
	public void updateIssueCar(@Param("number") int number, @Param("carno") String carno);
	
	@Modifying
	@Transactional
	@Query(value = "update userdetail set returnstatus=:status where carno=:carno", nativeQuery=true)
	public void updateReturnStatus(@Param("status") String status, @Param("carno") String carno);

	@Query()
	public ProvidedCar findByUsername(String username);

}
