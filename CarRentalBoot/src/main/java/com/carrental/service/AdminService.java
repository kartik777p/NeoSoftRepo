package com.carrental.service;

import java.util.List;
import java.util.Optional;

import com.carrental.entities.Seller;

public interface AdminService {
	public void addSeller(Seller seller);
	public List<Seller> viewSellers();
	public Seller getSellerById(int id);
	public int addEditedSeller(Seller seller);
	public void deleteSeller(int id);
	public Optional<Seller> checkLoginCredentials(String email, String password);
}
