package com.neosoft.bankproject;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CreateAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	// property
	 private static ArrayList<BankAccount> accounts=new ArrayList<BankAccount>();

	public static  ArrayList<BankAccount> getAccounts() {
		return accounts;
	}
	// createaccount
	public void createAccount() {
		Scanner sc = null;
		String accNo,name, addrs, mono, uname, pass, type = null;
		float initDep, amount = 0.0f;
		BankAccount acc=null;
		ObjectOutputStream oos=null;
		String outFile=null;

		// now gather values from end usr
		sc = new Scanner(System.in); 
		System.out.println("------------Create Account Page ------------");
		System.out.println("Enter Account Number  of the Customer :- ");
		accNo=sc.next();
		System.out.println("Enter Name of the Customer :- ");
		name=sc.next();
		System.out.println("Enter Adress of the Customer :- ");
		addrs=sc.next();
		System.out.println("Enter MobileNumber of the Customer :- ");
		mono=sc.next();
		System.out.println("Enter username for the Customer :- ");
		uname=sc.next();
		/*System.out.println("Enter Password for  the Customer :- ");
		pass=sc.next();
		*/
		System.out.println("Enter Password for  the Customer :- ");
		pass=sc.next();
		while (!pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$")) {
			System.out.println("Invalid Password ! Password Must Contains Alphanumeric with Atleast one Special Symboll");
			System.out.print("Please Enter  Strong Password again :");
			pass = sc.next();
		}
		System.out.println("Enter Initial deposit amount of the Customer :- ");
		initDep=sc.nextFloat();
		System.out.println("Enter type of th count for  the Customer :-");
		type=sc.next();
		//store that values to to Bankaccount class
		acc=new BankAccount(accNo,name, addrs, mono, uname, pass, initDep, type);
		//now add this object to list
		accounts.add(acc);
		//now add account  to file 
		 outFile="Resources/AccountDetails.txt";  //location
		 try {
		oos=new ObjectOutputStream(new FileOutputStream(outFile));
		//now add account obj to file 
		   for(BankAccount bnkAcc: accounts) {
			   oos.writeObject(bnkAcc);
		   }
		 }catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Account Created Sucesfully !!!!!!!!!!!!!");
		/*System.out.println(accounts.size());
		    for(BankAccount acc1:accounts) {
			   System.out.println("The account details for the customer "+acc1.getName()+" is :- ");
		    	 System.out.println("Name :- \t "+acc1.getName());
		    	 System.out.println("Adress :- \t "+acc1.getAdd());
		    	 System.out.println("MobileNumber :-  \t"+acc1.getCno());
		    	 System.out.println("UserName  :-  \t"+acc1.getUname());
		    	 System.out.println("Password :-  \t"+acc1.getPwd());
		    	 System.out.println("Amount :-  \t"+acc1.getAmt());
		    	 System.out.println("Account Type :-  \t"+acc1.getType());
		    	 System.out.println("-----------------------------------------");
		   }//for
	    */
	}//method   
 //display accounts lists
	public void showAccount() {
		int size=0;
		System.out.println("CreateAccount.showAccount()");
		    size=accounts.size();
		    if(size!=0) {
		     for(BankAccount acc: accounts) {   
		    	System.out.println("\t The account details for the customer "+acc.getName().toUpperCase()+" is :- ");
		    	System.out.println("----------------------------------------------------------------------------------------------------------------------");
		    	System.out.println("\t Account Number :-  \t\t\t\t"+acc.getAccNumber());
		    	 System.out.println("\t Name :- \t\t\t\t "+acc.getName());
		    	 System.out.println("\t Adress :- \t\t\t \t"+acc.getAdd());
		    	 System.out.println("\t MobileNumber :- \t\t \t\t"+acc.getCno());
		    	 System.out.println("\t UserName  :-  \t\t\t\t"+acc.getUname());
		    	 System.out.println("\t Password :-  \t\t\t\t"+acc.getPwd());
		    	 System.out.println("\t Amount :-  \t\t\t\t"+acc.getAmt());
		    	 System.out.println("\t Account Type :- \t\t \t\t"+acc.getType());
		    	 System.out.println("-----------------------------------------");
		     }//for
		    }//if
		    else {
		    	System.out.println("There is no Record to display ");
		    }//else
	}//method
}// class
