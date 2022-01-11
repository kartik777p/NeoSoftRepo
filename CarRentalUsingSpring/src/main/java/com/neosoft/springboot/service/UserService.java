package com.neosoft.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.neosoft.springboot.bean.CustomerBean;
import com.neosoft.springboot.bean.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	CustomerBean save(UserRegistrationDto registrationDto);
}
