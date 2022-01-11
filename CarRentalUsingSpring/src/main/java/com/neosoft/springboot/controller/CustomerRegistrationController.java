package com.neosoft.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neosoft.springboot.bean.UserRegistrationDto;
import com.neosoft.springboot.service.UserService;

@Controller
@RequestMapping("/custregistration")
public class CustomerRegistrationController {
	@Autowired
	private UserService userService;

	
	@ModelAttribute("customer")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "customer_registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("customer") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/custregistration?success";
	}
}
