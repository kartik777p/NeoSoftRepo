package com.neosoft.bankprojectwithjava8;

import java.util.ArrayList;
import java.util.Scanner;

public class UserLoginWithNonStaticMethRef {
	
	public void Login1() {
		Scanner sc=null;
		String uName;
		String password=null;
		String pass[]=new String[1];
		boolean [] flag= {false};
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
		pass[0]=password;
		//get list of accounts
		accounts=CreateAccountImplWithLambda.getAccounts();
			accounts.forEach(acc->{
				  if( (acc.getUname().equals(uName))    &&     ( acc.getPwd().equals(pass[0])) ) {
					  //make flag as true
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
				  }
			});
			if(flag[0]==false) {
				try {
				throw new AccountNotFoundException("There Is No Accounts Founds For the Given Id And Password..");
				}catch (AccountNotFoundException anfe) {
					anfe.printStackTrace();
				}//catch
			}//if
	}//login1
	
	public void login() {
		ILoginUser ilu=new UserLoginWithNonStaticMethRef()::Login1;
		//call method
		ilu.login();
	}//login
}//class
