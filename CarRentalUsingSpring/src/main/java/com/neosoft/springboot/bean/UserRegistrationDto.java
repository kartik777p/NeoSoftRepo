package com.neosoft.springboot.bean;

public class UserRegistrationDto {
	private Long id;
	private String name;
	private String password;
	private String email;
	private long mobile;
	
	public UserRegistrationDto(){
		
	}

	public UserRegistrationDto(Long id,String name, String password, String email, long mobile) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
}
