package com.neosoft.besics;

public class Student {
	
	//properties
	private int sNo;
	private String sName;
	private String course;
	private int marks;
	//CONS
	public Student(int sNo, String sName, String course, int marks) {
		this.sNo = sNo;
		this.sName = sName;
		this.course = course;
		this.marks = marks;
	}
	//dispay details
	public void showDetails() {
		System.out.println("SNO:- "+sNo+" Name:- "+sName+" Course :- "+course+" Marks:- "+marks);
	}

}
