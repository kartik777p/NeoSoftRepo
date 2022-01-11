package com.neosoft.springboot.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rent_car")
public class RentCarBean {
	@Id
	private Long carno;
	
	private Long customerid;
	private String customername;
	private long customermobile;
	private Date renteddate;
	private String returnstatus;

	

}
