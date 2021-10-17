package com.neosoft.bankproject;

import java.util.ArrayList;
import java.util.Scanner;

public class TransferMoney {
	ArrayList<BankAccount> accounts=CreateAccount.getAccounts();
	
	public  void tranferMoney( ) {
		Scanner sc=null;
		String src,dest=null;
		float rs=0.0f;
		//String srcStatus,destStatus=null;
		BankAccount srcAcc=null;
		BankAccount destAcc=null;
		String srcAccNum=null;
		String destAccNum=null;
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Transfer Money Page ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println();
		
		sc=new Scanner(System.in);
		System.out.println("Enter Source Account Number ");
		src=sc.next();
		System.out.println("Enter Destination Account Number ");
		dest=sc.next();
		System.out.println("Enter Amount ..How much money you want to send ");
		rs=sc.nextFloat();
		//get src account details and dest acc details
		if(accounts!=null) {
		for(BankAccount acc:accounts) {
			//check src account verification
			   if( acc.getAccNumber().equals(src)) {
				   //assign that obj as Sourc Account
				   srcAcc=acc;
			   }
			   //dest account Verification
			   if(acc.getAccNumber().equals(dest)) {
				   //assign that object as dest account 
				     destAcc=acc;
			   }//if
			   else {
				   System.out.println("Invalid source and Destination Account ");
			   }//else
		    }//for
		}//if
		else {
			System.out.println("There is no record to do Tranfer Operations ");
		}
		if(srcAcc.getAmt()<=rs) {
			try {
			throw new InsufficientBalenceException("Insiccfient balence ");
			}catch (Exception e) {
				e.printStackTrace();
			}//catch
		}//if
		else {
			//deposit money to dest account
			destAcc.setAmt(rs);
			//reduce money from src account
			float minusAcc=srcAcc.getAmt()-rs;
			srcAcc.setAmt(minusAcc);
			System.out.println("Money Transfer Sucessfully!!!!!!!!!!!!!!");
		}//else
	}//transferMoney
}//class
