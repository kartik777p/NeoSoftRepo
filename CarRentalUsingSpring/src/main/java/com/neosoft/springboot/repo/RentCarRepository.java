package com.neosoft.springboot.repo;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.neosoft.springboot.bean.RentCarBean;
import org.springframework.stereotype.Repository;
@Repository
public interface RentCarRepository extends JpaRepository<RentCarBean, Long>{
	List<RentCarBean> findByReturnstatusOrderByRenteddateDesc(String returnStatus);
	
	@Transactional
	@Modifying
	@Query("update RentCarBean r set r.returnstatus='yes' where r.carno=:carno and r.customerid=:id")
	int updateRentedCarStatus(@Param("carno") long carno, @Param("id") long id);
	
}
