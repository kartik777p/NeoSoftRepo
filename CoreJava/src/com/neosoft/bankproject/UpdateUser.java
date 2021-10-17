package com.neosoft.bankproject;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateUser {
	ArrayList<BankAccount> accounts = CreateAccount.getAccounts();

	public void update() {
		Scanner sc = null;
		int choiseNo = 0;
		sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------------");
		System.out.println(" Update BankDetails Page ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println();
		System.out.println("Which Of the Following  Details you Want to Update ");
		System.out.println("-----------------------------------------------------------------------------------------");

		System.out.println();

		System.out.println("1. Name");
		System.out.println("2. Address");
		System.out.println("3. Mobile Number");
		System.out.println("4. UserName ");
		System.out.println("5. Password ");

		System.out.println("6. Exit");
		System.out.println();
		// get user choise and show option for their choise
		System.out.println("Enter Your Choise Number");
		choiseNo = sc.nextInt();
		switch (choiseNo) {
		case 1:
			updateName();
			break;
		case 2:
			updateAddress();
			break;
		case 3:
			updateMobileNumber();
			break;
		case 4:
			updateUserName();
			break;
		case 5:
			updatePassword();
			break;

		case 6:
			System.out.println("Thank you .........................");
		}// switch
	}// UpdateUser

	public void updateName() {
		Scanner sc = null;
		String name = null;
		sc = new Scanner(System.in);
		System.out.println("Enter a new Name :- ");
		name = sc.next();
		for (BankAccount acc : accounts) {
			acc.setName(name);
			System.out.println("Name Updated Succesfully !!!!!!!!!!!!!!!!!!");
		}

	}// updateName

	public void updateAddress() {
		Scanner sc = null;
		String Address = null;
		sc = new Scanner(System.in);
		System.out.println("Enter a new Address :- ");
		Address = sc.next();
		for (BankAccount acc : accounts) {
			acc.setAdd(Address);
			System.out.println("Address Updated Succesfully !!!!!!!!!!!!!!!!!!");
		} // for
	}// update address

	public void updateMobileNumber() {
		Scanner sc = null;
		String mobileNumber = null;
		sc = new Scanner(System.in);
		System.out.println("Enter a new mobileNumber :- ");
		mobileNumber = sc.next();
		for (BankAccount acc : accounts) {
			acc.setCno(mobileNumber);
			System.out.println("mobileNumber Updated Succesfully !!!!!!!!!!!!!!!!!!");
		} // for
	}// updateMobileNumber

	public void updateUserName() {
		Scanner sc = null;
		String username = null;
		sc = new Scanner(System.in);
		System.out.println("Enter a new username :- ");
		username = sc.next();
		for (BankAccount acc : accounts) {
			acc.setUname(username);
			System.out.println("username Updated Succesfully !!!!!!!!!!!!!!!!!!");
		} // for
	}// updateUserName

	public void updatePassword() {
		Scanner sc = null;
		String password = null;
		sc = new Scanner(System.in);
		System.out.println("Enter a new password :- ");
		password = sc.next();
		for (BankAccount acc : accounts) {
			acc.setPwd(password);
			System.out.println("password Updated Succesfully !!!!!!!!!!!!!!!!!!");
		} // for
	}// updatePassword
}// class
