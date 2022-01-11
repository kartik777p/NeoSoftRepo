package com.neosoft.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neosoft.springboot.bean.CarBean;
import com.neosoft.springboot.bean.CustomerBean;
import com.neosoft.springboot.bean.RentCarBean;
import com.neosoft.springboot.repo.CarRepository;
import com.neosoft.springboot.repo.CustomerRepository;
import com.neosoft.springboot.repo.RentCarRepository;
import com.neosoft.springboot.service.CarService;
import com.neosoft.springboot.service.CustomerServiceImpl;
import com.neosoft.springboot.service.RentedCarService;



@Controller
//@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RentCarRepository rentCarRepository;
	
	@Autowired
	RentedCarService rentCarService;
	
	@GetMapping("/customer")
	public String getdashboard(Model model) {
		return "customer_dashboard";
	}
	
	@GetMapping("/customer/rentCarList")
	public String viewrentPage(Model model) {
		
		List<CarBean> listCars = carRepo.findByRented("no");
		model.addAttribute("listCars", listCars);
		return "rent_cars";	
	}
	
	@GetMapping("/customer/bookcar/{id}")
	public String bookcar(@PathVariable long id, Model model, @AuthenticationPrincipal UserDetails currentUser ) {
		CustomerBean user = (CustomerBean) customerRepository.findByEmailEquals(currentUser.getUsername());
		
		java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
		rentCarService.saveRentedCarData(new RentCarBean(id, user.getId(), user.getName(),user.getMobile(), currentDate, "no"));
		carRepo.updateRentedCarStatus("yes", id);
		return "redirect:/customer/rentCarList?success";
	}
	
	@PostMapping("/customer/rentCarList/search")
	public String searchRentCars(@RequestParam("search") String input, Model model) {
		
		List<CarBean> listCars = carRepo.findByRentedAndCompanyNameContaining("no", input);
		model.addAttribute("listCars", listCars);
		return "rent_cars";	
	}
	
	
	/* ------------------ return car --------------------*/
	@GetMapping("/customer/returnCarList")
	public String viewReturnPage(Model model) {
		model.addAttribute("carsToReturn",rentCarRepository.findByReturnstatusOrderByRenteddateDesc("no"));
		return "return_car";
	}
	
	@GetMapping("/customer/returncar/{id}")
	public String returncar(@PathVariable("id") long id, Model model, @AuthenticationPrincipal UserDetails currentUser ) {
		CustomerBean user = (CustomerBean) customerRepository.findByEmailEquals(currentUser.getUsername());
		carRepo.updateRentedCarStatus("no", id);
		rentCarRepository.updateRentedCarStatus(id, user.getId());
		return "redirect:/customer/returnCarList?success";
	}
}
