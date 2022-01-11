package com.neosoft.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.neosoft.springboot.bean.CustomerBean;

public interface CustomerService{
	void saveOrUpdate(CustomerBean customer);
	void deleteById(long id);
	List<CustomerBean> getAllCustomers();
	CustomerBean getCustomerById(long id);
	Page<CustomerBean> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
