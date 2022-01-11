package com.carrental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrental.entities.Seller;
import com.carrental.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	public AdminRepo adminRepo;
	
	@Override
	public void addSeller(Seller seller) {
		adminRepo.save(seller);
		
	}
	
	@Override
	public List<Seller> viewSellers(){
		return adminRepo.findAll();
	}
	
	@Override
	public Seller getSellerById(int id) {
		Optional<Seller> seller= adminRepo.findById(id);
		if(seller.isPresent()) {
			return seller.get();
		}
		return null;
	}
	
	@Override
	public int addEditedSeller(Seller seller) {
		String name = seller.getName();
		String email = seller.getEmail();
		String password = seller.getPassword();
		String mobile = seller.getMobile();
		int id = seller.getId();
		System.out.println(name+" "+email+" "+password+" "+mobile+" "+id);
		int status = adminRepo.updateSellerInfo(name, email, password, mobile, id);
		return status;
	}
	
	@Override
	public void deleteSeller(int id) {
		adminRepo.deleteById(id);
	}
	
	@Override
	public Optional<Seller> checkLoginCredentials(String email, String password) {
		return adminRepo.findByEmailAndPassword(email, password);
	}

	
}
