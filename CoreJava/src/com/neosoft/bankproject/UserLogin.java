package com.neosoft.bankproject;

import java.util.ArrayList;
import java.util.Scanner;

import com.neosoft.bankprojectwithjava8.ILoginUser;
import com.neosoft.bankprojectwithjava8.IUpdateUser;


public class UserLogin {
   
	public void login() {
		//Scanner sc=null;
		//String uName;
		String[] password=new String[1];
		//String pass=null;
		boolean [] flag= {false};
		ILoginUser ilu=null;
		//ArrayList<BankAccount> accounts=null;
		ilu=()->{
		//read values from end user
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Account Login ");
		System.out.println("--------------------------------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.println("    Enter UserName ");
		String uName=sc.next();
		System.out.println("Enter Password ");
		String pass=sc.next();
		password[0]= pass;
		//password=sc.next();
		//get list of accounts
		
		ArrayList<BankAccount> accounts=CreateAccount.getAccounts();
		accounts.stream().forEach(acc -> {
			 if( (acc.getUname().equals(uName))    &&     ( acc.getPwd().equals(password)) ) {
				 //make flag as true;
				 flag[0]=true;
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
		});
		if(flag[0]==false) {
			try {
			throw new UserNotFoundException("There is  No User Found For The Given Credentials");
			}catch (UserNotFoundException unfe) {
				unfe.printStackTrace();
			}//catch
		}//if
		/*if(accounts!=null) {
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
		}//else    */
		//call method
		}; //lambda
		 ilu.login();
	}//method
}//class
