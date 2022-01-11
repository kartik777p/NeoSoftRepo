package com.neosoft.springboot.service;

import java.util.Arrays;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.bean.CustomerBean;
import com.neosoft.springboot.bean.Role;
import com.neosoft.springboot.bean.UserRegistrationDto;
import com.neosoft.springboot.repo.CustomerRepository;

import lombok.extern.slf4j.Slf4j;


@Service @Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;	

	@Override
	public CustomerBean save(UserRegistrationDto registrationDto) {
		String USER_MAIL = registrationDto.getEmail();
		String ROLE = "ROLE_CUSTOMER";
		if(USER_MAIL.equals("admin@admin.com"))
			ROLE = "ROLE_ADMIN";
		
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(ROLE));
			
		CustomerBean user = new CustomerBean(registrationDto.getName(),passwordEncoder.encode(registrationDto.getPassword()),
				registrationDto.getEmail(), registrationDto.getMobile(), roles);
		
		return customerRepository.save(user);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		CustomerBean user = customerRepository.findByEmailEquals(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	
	

}
