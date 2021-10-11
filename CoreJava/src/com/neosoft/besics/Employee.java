package com.neosoft.besics;

public class Employee {
	int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	String name;
	int deptNo;
	double sal;
	
	//showId
	public void showId() {
		System.out.println("id is :- "+id);
	}	
}
