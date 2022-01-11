package com.neosoft.springboot.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "car_info")
public class CarBean {
	
	@Id
	private Long carno;
	
	@Column(name = "company_name", nullable = false)
	private String companyName;
	
	@Column(name = "model", nullable = false)
	private String model;
	
	@Column(name = "year", nullable = false)
	private int year;
	
	@Column(name = "rent_price", nullable = false)
	private int rentedprice;
	
	@Column(name = "rented", nullable = false)
	private String rented;
	

}
