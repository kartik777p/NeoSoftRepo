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
		System.out.println("UserLogin.login()");
		sc=new Scanner(System.in);
		System.out.println("    Enter UserName ");
		uName=sc.next();
		System.out.println("Enter Password ");
		password=sc.next();
		//get list of accounts
		accounts=CreateAccount.getAccounts();
		if(accounts!=null) {
		for(BankAccount acc:accounts) {
			  if(acc.getUname().equ)
		}
		}else {
			System.out.println("There is No record found to match your gmail id and password   ");
		}
	}//method
}//class
