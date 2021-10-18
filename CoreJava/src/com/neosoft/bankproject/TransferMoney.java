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
		//String srcAccNum=null;
		//String destAccNum=null;
		String srcStr="notFound";
		String destStc="notFound";
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Transfer Money Page ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println();
		
		sc=new Scanner(System.in);
		System.out.println("Enter Source Account Number ");
		src=sc.next();
		if(accounts!=null) {
			for(BankAccount acc:accounts) {
				//check src account verification
				   if( acc.getAccNumber().equals(src)) {
					   System.out.println();
					   System.out.println("Source Account Found ");
					   srcStr="found";
					   //assign that obj as Sourc Account
					   srcAcc=acc; 
				   }else if(srcStr!="found") {
					   try {
						   throw new AccountNotFoundException("Source Account  Not Found ");
						   }catch (AccountNotFoundException anfe) {
							anfe.printStackTrace();
						}//catch
				   }//else
			}//for
		}//if
		else {
			System.out.println("There is no record to do Tranfer Operations ");
		}//else
		System.out.println("Enter Destination Account Number ");
		dest=sc.next();
		   //dest account Verification
		if(accounts!=null) {
		for(BankAccount acc:accounts) {
		   if(acc.getAccNumber().equals(dest)) {
			   //assign that object as dest account 
			   System.out.println();
			   System.out.println("Destination Account Found ");
			   destStc="found";
			     destAcc=acc;
		   }//if
		 /*  else if(destStc!="found"){
			   try {
			   throw new AccountNotFoundException("Destination Accoount Not Found ");
			   }catch (AccountNotFoundException anfe) {
				anfe.printStackTrace();
			}//catch
			   }//else   */
	    }//for
	}//if
		else {
		System.out.println("There is no record to do Tranfer Operations ");
	}//else
	System.out.println("Enter Amount ..How much money you want to send ");
		rs=sc.nextFloat();
		if(srcAcc.getAmt()<=rs) {
			try {
			throw new InsufficientBalenceException("Insiccfient balence ");
			}catch (Exception e) {
				e.printStackTrace();
			}//catch
		}//if
		else {
			//deposit money to dest account
			destAcc.setAmt(rs,"depo");
			//reduce money from src account
			float minusAcc=srcAcc.getAmt()-rs;
			srcAcc.setAmt(minusAcc,"with");
			System.out.println("Money Transfer Sucessfully!!!!!!!!!!!!!!");
		}//else
	}//transferMoney
}//class
