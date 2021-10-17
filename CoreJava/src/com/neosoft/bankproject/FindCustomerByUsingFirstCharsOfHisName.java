package com.neosoft.bankproject;

import java.util.ArrayList;
import java.util.Scanner;

public class FindCustomerByUsingFirstCharsOfHisName {
	private static ArrayList<BankAccount> accounts = CreateAccount.getAccounts();

	public void findUserByItsfirstChars() {
		Scanner sc = null;
		String inichar = null;
		sc = new Scanner(System.in);
		System.out.println("Enter initial Chars  One/More :- ");
		inichar = sc.next();
		// now check any user is there or not having this chars  as Initial chars
           for(BankAccount bnk: accounts) {
        	   if(bnk.getName().startsWith(inichar)) {
        		   System.out.println("\t The account details for the customer "+bnk.getName().toUpperCase()+" is :- ");
   		    	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
   		    	System.out.println("\t Account Number :-  \t\t\t\t"+bnk.getAccNumber());
   		    	 System.out.println("\t Name :- \t\t\t\t "+bnk.getName());
   		    	 System.out.println("\t Adress :- \t\t\t \t"+bnk.getAdd());
   		    	 System.out.println("\t MobileNumber :- \t\t \t\t"+bnk.getCno());
   		    	 System.out.println("\t UserName  :-  \t\t\t\t"+bnk.getUname());
   		    	 System.out.println("\t Password :-  \t\t\t\t"+bnk.getPwd());
   		    	 System.out.println("\t Amount :-  \t\t\t\t"+bnk.getAmt());
   		    	 System.out.println("\t Account Type :- \t\t \t\t"+bnk.getType());
   		    	 System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        	   }//if
        	   else {
        		   try {
        		   throw new UserNotFoundException("No User found Having This chars as Initial Chars ");
        		   }//try
        		   catch (UserNotFoundException unfe) {
        			   unfe.printStackTrace();
				}//catch
        	   }//else
           }//for
	}// findUserByItsfirstChars
}// class
