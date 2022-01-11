package com.neosoft.springboot.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neosoft.springboot.bean.CustomerBean;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<CustomerBean, Long>{
	CustomerBean findByEmailEquals(String username);

}
