package com.neosoft.sessiontask;

import java.util.Scanner;

public class BankAccountTestConsoleProject {

	// showfeatures
	public void ShowMenus() {
		Scanner sc=null;
		int choiseNo=0;
		//show menu
	     sc = new Scanner(System.in);
		System.out.println("-----------------------------");
		System.out.println("BANK   OF  "+BankAccount.getBankName()); //convert bank name to uppercase 
		System.out.println("-----------------------------");

		System.out.println("1. Register Account");
		System.out.println("2. Login");
		System.out.println("3. Update accounts");
		System.out.println("4. Exit");
		System.out.println();
		//get  user choise and show option for their choise
      System.out.println("Enter Your Choise Number");
      choiseNo=sc.nextInt();
	}

	public static void main(String[] args) {
		Scanner sc = null;
		String bName = null;
		BankAccountTestConsoleProject test=null;
		
		// create scanner
			sc = new Scanner(System.in);
			// get bankName from user
			System.out.println("Enter Bank Name :- ");
			//set Name to  BankAccount
			//now show bankMenu to EndUser
			test=new BankAccountTestConsoleProject();
		     test.ShowMenus();
	}//main
}//class
