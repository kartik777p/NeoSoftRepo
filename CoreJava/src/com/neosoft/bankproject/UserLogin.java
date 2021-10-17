package com.neosoft.bankproject;

import java.util.ArrayList;
import java.util.Scanner;


public class UserLogin {
   
	public void login() {
		Scanner sc=null;
		String uName;
		String password=null;
		ArrayList<BankAccount> accounts=null;
		//read values from end user
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Account Login ");
		System.out.println("--------------------------------------------------------------------");
		sc=new Scanner(System.in);
		System.out.println("    Enter UserName ");
		uName=sc.next();
		System.out.println("Enter Password ");
		password=sc.next();
		//get list of accounts
		accounts=CreateAccount.getAccounts();
		if(accounts!=null) {
		for(BankAccount acc:accounts) {
			  if( (acc.getUname().equals(uName))    &&     ( acc.getPwd().equals(password)) ) {
				  System.out.println();
				  System.out.println("------------------------------------------------------Logged In Sucessfully!!!!!!!!!!!!!--------------------------------------");
				  //show profile of that user
				  System.out.println(" \t \t \t \t \t \t  User Profile \t \t \t \t ");
				  System.out.println("\t Account Number :: - \t\t\t\t\t\t\t\t"+acc.getAccNumber());
				  System.out.println("\t Customer Name :: - \t\t\t\t\t\t\t\t"+acc.getName());
				  System.out.println("\t Customer Address :: -\t\t \t\t\t\t\t\t"+acc.getAdd());
				  System.out.println("\t Mobile Number :: - \t\t\t\t\t\t\t\t"+acc.getCno());
				  System.out.println("\t Customer Username :: - \t\t\t\t\t\t\t\t"+acc.getUname());
				  System.out.println("\t Customer Password :: - \t\t\t\t\t\t\t\t"+acc.getPwd());
				  System.out.println("\t Account Balence  :: - \t\t\t\t\t\t\t\t"+acc.getAmt());
				  System.out.println("\t Account type :: - \t\t\t\t\t\t\t\t"+acc.getType());
			  }//if
		}//for
		}//if
		else {
			System.out.println("There is No record found to match your gmail id and password   ");
		}//else
	}//method
}//class
