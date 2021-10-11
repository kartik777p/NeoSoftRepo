package com.neosoft.besics;

import java.io.Serializable;
import java.util.Date;

public class Trainer implements Serializable {
	private static final long serialVersionUID = 1L;
	 private String name;
	 private Date birthdate;
	 private boolean gender;
	 private int age;
	 private float salary;
	 //cons
	 public Trainer() { }
	 //param cons
	public Trainer(String name, Date birthdate, boolean gender, int age, float salary) {
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
	}
	//setters and getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
