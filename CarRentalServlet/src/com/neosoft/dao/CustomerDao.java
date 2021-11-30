package com.neosoft.dao;

import java.util.List;

import com.neosoft.beans.Customer;

public interface CustomerDao {
  // save customer 
	public  int save(Customer bean);
	////update customer
	public  int update(Customer bean);
	// view all customers
	public  List<Customer> view();
	//view customer by Id
	public  Customer viewById(int id);
	// delete customer
	public  int delete(int id);
	// authenticate user
	public  boolean authenticate(String email,String password);
	// get id 
	public  int getId(String email,String password);	
}
