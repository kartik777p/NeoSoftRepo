package com.neosoft.bankproject;

import java.util.ArrayList;
import java.util.Scanner;

public class TransferMoney {
	ArrayList<BankAccount> accounts=CreateAccount.getAccounts();
	
	public  void tranferMoney( ) {
		Scanner sc=null;
		String src,dest=null;
		double rs=0.0f;
		sc=new Scanner(System.in);
		System.out.println("Enter Source Account Number ");
		src=sc.next();
		System.out.println("Enter Destination Account Number ");
		dest=sc.next();
		System.out.println("Enter Amount ..How much money you want to send ");
		rs=sc.nextFloat();
		//get src account details
		System.out.println(accounts.size());
		
		
	}
}
