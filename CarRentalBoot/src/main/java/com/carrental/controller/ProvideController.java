package com.carrental.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carrental.entities.ProvidedCar;
import com.carrental.service.ProvideService;

@Controller
public class ProvideController {

	@Autowired
	public ProvideService provideService;

	@GetMapping("/ProvideCar")
	public String provideCar(HttpSession session) {
		if (session.getAttribute("seller") != null) {
		return "providecar";
		}
		session.setAttribute("loginerror", "You have to login as Seller for access this page");
		return "redirect:/SellerLogin";
	}

	@PostMapping("/Seller/ProvideCar")
	public String saveProvideCarDetail(@ModelAttribute ProvidedCar providecar, HttpSession session) {
		if (session.getAttribute("seller") != null) {
		int checkCar = provideService.checkCar(providecar.getCarno());
		if (checkCar > 0) {
			int checkNoOfCar = provideService.checkCarExist(providecar.getCarno());
			int issuecar = provideService.noOfIssuedCar(providecar.getCarno());
			int availNoOfCar = checkNoOfCar - issuecar;
			if (availNoOfCar > 0) {
				int num = issuecar + 1;
				System.out.println("cars" + num);
				provideService.addProvideCar(num, providecar);
				session.setAttribute("savecar", "Car Provide Successfully...");
			} else {
				session.setAttribute("savecarerror", "We May Have sortage of this car, you can try another car");
			}
		} else {
			session.setAttribute("savecarerror", "we do not have this car");
		}
		return "redirect:/ProvideCar";
		}
		session.setAttribute("loginerror", "You have to login as Seller for access this page");
		return "redirect:/SellerLogin";
	}

	@GetMapping("/ViewProvidedCar")
	public String viewProvidedCar(Model model , HttpSession session) {
		if (session.getAttribute("seller") != null) {
		List<ProvidedCar> custs = provideService.viewProvidedCars();
		model.addAttribute("customers", custs);
		return "viewprovidedcar";
		}
		session.setAttribute("loginerror", "You have to login as Seller for access this page");
		return "redirect:/SellerLogin";
	}

	@GetMapping("/ReturnCar")
	public String returnCar(HttpSession session) {
		if (session.getAttribute("seller") != null) {
		return "returncar";
		}
		session.setAttribute("loginerror", "You have to login as Seller for access this page");
		return "redirect:/SellerLogin";
	}

	@PostMapping("/SaveReturnInfo")
	public String saveReturnInfo(@RequestParam String carno, @RequestParam String useremail,
			@ModelAttribute ProvidedCar providecar, HttpSession session) {
		Optional<ProvidedCar> cust = provideService.checkCustomer(carno, useremail);
		if (cust.isPresent()) {
			int issuecar = provideService.noOfIssuedCar(providecar.getCarno());
			System.out.println("Issue car : " + issuecar);
			if (issuecar > 0) {
				int num = issuecar - 1;

				System.out.println("Num : " + num);
				provideService.updateReturnDetails(num, "yes", carno);
				session.setAttribute("savecar", "Car Returned Successfully...");
				return "redirect:/ReturnCar";
			}else {
				session.setAttribute("savecarerror", "This car is already returned by the customer");
			}
		} else {
			session.setAttribute("savecarerror", "you may enter incorrect detail or this car is not provided to anyone");
		}
		return "redirect:/ReturnCar";
	}
	
	@GetMapping("/Search")
	public String search() {
		return "searchprovidedcar";
	}
	
	@PostMapping("/SearchProvidedCar")
	public String searchProvidedCar(@ModelAttribute ProvidedCar cars, Model model,HttpSession session){
		
		System.out.println(cars.getUsername());
		ProvidedCar result = provideService.searchByName(cars.getUsername());
		
		if(result!=null) {
			System.out.println("res "+result);
			model.addAttribute("results", result);
		}
		else {
			System.out.println("not found ");
			session.setAttribute("searcherror", "No Result Found");
		}
		return "searchprovidedcar";
	}
}
