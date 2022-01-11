package com.neosoft.springboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neosoft.springboot.bean.CarBean;
import com.neosoft.springboot.bean.CustomerBean;
import com.neosoft.springboot.repo.CarRepository;
import com.neosoft.springboot.repo.CustomerRepository;
import com.neosoft.springboot.repo.RentCarRepository;
import com.neosoft.springboot.service.CarService;
import com.neosoft.springboot.service.CustomerService;
import com.neosoft.springboot.service.RentedCarService;

@Controller
public class AdminController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RentCarRepository rentCarRepository;
	
	@Autowired
	RentedCarService rentCarService;
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
		return "admin_dashboard";
	}
	
	//add Cars
	@GetMapping("/admin/addCarForm")
	public String addCarForm(Model model) {
		//create car obj
		CarBean car = new CarBean();
		//save that car to model atr
		model.addAttribute("car", car);
		//return tml page 
		return "add_car";
	}
	
	@PostMapping("/admin/saveCarDetails")
	public String saveCar(@ModelAttribute("car") CarBean car) {
		// save car to database
		car.setRented("no");
		carService.saveCar(car);
		return "redirect:/admin/addCarForm?success";
	}
	
	//view cars 
	@GetMapping("/admin/viewCars")
	public String viewCarsPage(Model model) {
		return findPaginated(1, "companyName", "asc", model);		
	}
	
	
	@GetMapping("/admin/deleteCarRecord/{id}")
	public String deleteCarRecord(@PathVariable("id") long id) {
		carService.deleteCarById(id);
		return "redirect:/admin/dashboard?success";		
	}
	
	// View Rented Cars
	@GetMapping("/admin/viewRentedCars")
	public String viewRentedPage(Model model) {
		model.addAttribute("carsToReturn",rentCarRepository.findByReturnstatusOrderByRenteddateDesc("no"));
		return "view_rented_cars";
	}
	
	// view customers
	@GetMapping("/admin/viewCustomers")
	public String viewCustomersPage(Model model) {
		model.addAttribute("customersList",customerService.getAllCustomers());
		return "view_customers";
	}
	
	@GetMapping("/admin/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		CustomerBean customer = customerService.getCustomerById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		return "update_customer";
	}
	
	@GetMapping("/admin/deleteCustomerRecord/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		customerService.deleteById(id);
		return "redirect:/admin/viewCustomers?success";
	}
	
	@GetMapping("/admin/editCustomerData")
	public String editCustomersDataPage(Model model) {
		model.addAttribute("customersList",customerService.getAllCustomers());
		return "view_customers";
	}
	
	@PostMapping("/admin/updateCustomerData")
	public String updateCustomerData(@ModelAttribute("customer") CustomerBean customer) {
		
		customerRepository.findById(customer.getId()).map(newCustomerData ->{
			newCustomerData.setName(customer.getName());
			newCustomerData.setEmail(customer.getEmail());
			newCustomerData.setMobile(customer.getMobile());
			return customerRepository.save(newCustomerData);
		});
		return "redirect:/admin/viewCustomers?success";
	}
	
	
	
	@GetMapping("/admin/viewCars/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<CarBean> page = carService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<CarBean> listCars = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listCars", listCars);
		return "view_cars";
	}
	
}
