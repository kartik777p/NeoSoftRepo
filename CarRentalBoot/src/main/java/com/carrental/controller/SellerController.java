package com.carrental.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.carrental.entities.Car;
import com.carrental.service.SellerService;

@Controller
public class SellerController {
	
	@Autowired
	public SellerService sellerService;
	
	
	
	@GetMapping("/AddCar")
	public String addCar(HttpSession session) {
		if (session.getAttribute("seller") != null) {
			return "addcar";
		}
		session.setAttribute("loginerror", "You have to login as Seller for access this page");
		return "redirect:/SellerLogin";
	}
	
	@GetMapping("/ViewCar")
	public String viewCar(Model model,HttpSession session) {
		if (session.getAttribute("seller") != null) {
		List<Car> cars = sellerService.viewCars();
		model.addAttribute("cars", cars);
		return "viewcar";
		}
		session.setAttribute("loginerror", "You have to login as Seller for access this page");
		return "redirect:/SellerLogin";
	}
	
	@PostMapping("/Seller/SaveCar")
	public String saveCarDetails(@ModelAttribute Car car, HttpSession session) {
		sellerService.addCar(car);
		session.setAttribute("savecar", "Car Added Successfully...");
		return "redirect:/AddCar";
	}
	
	@GetMapping("/editcar/{id}")
	public String editCar(@PathVariable int id, Model model) {
		Car car = sellerService.getCarById(id);
		System.out.println(car);
		model.addAttribute("carsval", car);
		return "editcar";
	}
	
	@PostMapping("/Seller/EditCar")
	public String saveEditedCar(@ModelAttribute Car car) {
		sellerService.addCar(car);
		return "redirect:/ViewCar";
	}
	
	@GetMapping("/DeleteCar/{id}")
	public String deleteCar(@PathVariable int id, HttpSession session) {
		session.setAttribute("modifycar", "Car Deleted Successfully...");
		sellerService.deleteCarById(id);
		return "redirect:/ViewCar";
	}
	
	@GetMapping("/SellerLogout")
	public String sellerLogout(HttpSession session) {
		session.removeAttribute("seller");
		return "redirect:/";
	}
	
	@GetMapping("/ContactUs")
	public String contact() {
		return "contactus";
	}
	
}
