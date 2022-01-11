package com.neosoft.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.bean.CustomerBean;
import com.neosoft.springboot.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public void saveOrUpdate(CustomerBean customer) {
		customerRepo.save(customer);
	}

	@Override
	public void deleteById(long id) {
		customerRepo.deleteById(id);
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public CustomerBean getCustomerById(long id) {
		Optional<CustomerBean> optional = customerRepo.findById(id);
		CustomerBean bean = null;
		if (optional.isPresent()) {
			bean = optional.get();
		} else {
			throw new RuntimeException(" Customer not found for id :: " + id);
		}
		return bean;
	}

	@Override
	public Page<CustomerBean> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.customerRepo.findAll(pageable);
	}
	
	
}
