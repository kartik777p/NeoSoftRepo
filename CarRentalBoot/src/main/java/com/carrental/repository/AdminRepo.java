package com.carrental.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carrental.entities.Seller;

public interface AdminRepo extends JpaRepository<Seller, Integer> {

	Optional<Seller> findByEmailAndPassword(String email, String password);

	@Modifying
	@Transactional
	@Query(value = "update car_rentee set name=:name, email=:email, password=:pw, mobile=:mno where id=:id", nativeQuery=true)
	public int updateSellerInfo(@Param("name") String name, @Param("email") String email, @Param("pw") String password, @Param("mno") String mobile, @Param("id") int id);
	
}
