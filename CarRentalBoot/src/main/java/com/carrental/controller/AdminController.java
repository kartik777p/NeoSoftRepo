package com.carrental.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carrental.entities.Seller;
import com.carrental.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	public AdminService adminService;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/AdminHome")
	public String adminHome(HttpSession session) {
		if (session.getAttribute("admin") != null) {
			session.removeAttribute("seller");
			return "adminhome";
		}
		session.setAttribute("loginerror", "You have to login as Admin for access this page");
		return "redirect:/AdminLogin";
	}

	@GetMapping("/AdminLogin")
	public String adminLogin() {
		return "adminlogin";
	}

	/*
	 * @PostMapping("/AdminAuthenticate") public String adminRegister(@RequestParam
	 * String email, @RequestParam String password) { if
	 * (email.equals("admin@gmail.com") && password.equals("admin")) {
	 * System.out.println("Emailllllllllll : "+email);
	 * 
	 * return "redirect:/adminhome"; } return "index"; }
	 */

	@PostMapping("/AdminAuthenticate")
	public String authenticateAdmin(@RequestParam String email, @RequestParam String password, HttpSession session) {
		if (email.equals("admin@gmail.com") && password.equals("admin")) {
			session.setAttribute("admin", "admin@gmail.com");
			return "adminhome";
		} else {
			session.setAttribute("credentials", "Wrong Credentails, Enter Correct Details");
		}
		return "adminlogin";
	}

	@GetMapping("/AddSeller")
	public String addSeller(HttpSession session) {
		if (session.getAttribute("admin") != null) {
			return "addseller";
		}
		session.setAttribute("loginerror", "You have to login as Admin for access this page");
		return "redirect:/AdminLogin";
	}

	@PostMapping("/Admin/SaveSeller")
	public String addSellerInfo(@ModelAttribute Seller seller, HttpSession session) {
		adminService.addSeller(seller);
		session.setAttribute("saveSeller", "Seller Added Successfully");
		return "redirect:/AddSeller";
	}

	@GetMapping("/ViewSeller")
	public String viewSeller(Model model,HttpSession session) {
		if (session.getAttribute("admin") != null) {
		List<Seller> sellers = adminService.viewSellers();
		model.addAttribute("seller", sellers);
		return "viewseller";
		}
		session.setAttribute("loginerror", "You have to login as Admin for access this page");
		return "redirect:/AdminLogin";
	}

	@GetMapping("/edit/{id}")
	public String editSeller(@PathVariable int id, Model m) {
		Seller seller = adminService.getSellerById(id);
		m.addAttribute("sellerval", seller);
		return "editseller";
	}

	@GetMapping("/edit")
	public String edit() {
		return "editseller";
	}

	@PostMapping("/Admin/UpdateSeller")
	public String updateSeller(@ModelAttribute Seller seller, HttpSession session) {
		int status = adminService.addEditedSeller(seller);
		System.out.println("status = " + status);
		if (status > 0) {
			session.setAttribute("saveSeller", "Seller Updated Successfully...");
			return "redirect:/ViewSeller";
		}
		session.setAttribute("saveSellerError", "Seller Not Updated, Try Again...");
		return "redirect:/ViewSeller";
	}

	@GetMapping("Admin/DeleteSeller/{id}")
	public String deleteSellerById(@PathVariable int id, HttpSession session) {
		adminService.deleteSeller(id);
		session.setAttribute("saveSeller", "Seller Deleted Successfully...");
		return "redirect:/ViewSeller";
	}

	@GetMapping("/SellerLogin")
	public String sellerLogin() {
		return "sellerlogin";
	}

	@GetMapping("/SellerHome")
	public String sellerHome(HttpSession session) {
		if (session.getAttribute("seller") != null) {
			return "sellerhome";
		}
		session.setAttribute("loginerror", "You have to login as Seller for access this page");
		return "redirect:/SellerLogin";
	}

	@PostMapping("/SellerAuthenticate")
	public String authenricateSeller(@RequestParam String email, @RequestParam String password, HttpSession session) {
		Optional<Seller> seller = adminService.checkLoginCredentials(email, password);
		if (seller.isPresent()) {
			session.setAttribute("seller", email);
			session.removeAttribute("admin");
			return "redirect:/SellerHome";
		} else {
			session.setAttribute("credentials", "Wrong Credentails, Enter Correct Details");
		}
		return "sellerlogin";
	}

	@GetMapping("Admin/logout")
	public String adminLogout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:/";
	}
}