package com.neosoft.bankproject;

import java.util.ArrayList;
import java.util.Scanner;

import com.neosoft.bookproject.Book;

public class DipositMoney {
	private static ArrayList<BankAccount> accounts=CreateAccount.getAccounts(); 
	public void depositMoney() {
		    Scanner sc=null;
		    boolean flag=false;
		    String desc=null;
		    float amt=0.0f;
		      sc=new Scanner(System.in);
		      System.out.println("--------------------------------------------------------------------");
		      System.out.println(" Deposit Money Page ");
		      System.out.println("--------------------------------------------------------------------");
		      System.out.println();
		      System.out.println("Enter Account Number Recipient person :- ");
		       desc=sc.next();
		       String str=null;  //
		       //check account number is present or not
		       for(BankAccount acc:accounts) {
		    	   if(acc.getAccNumber().equalsIgnoreCase(desc)) {
		    		    System.out.println(" \n \t \t  Account Found \t \t  ");
		    		    str="found";
		    	   }//if
		    	   else if(str!="found") {
		    		   try {
		    		   throw new  AccountNotFoundException("No account for the given Acc Number !!! please enter Correct Account Number and try again "); 
		    		   }//try
		    		   catch (AccountNotFoundException anfe) {
						anfe.printStackTrace();
					}//catch
		    		  return ; //return controll
		    	   }//else
		       }//for
		       System.out.println();
		       System.out.println("Enter Amount which you have to Desosit  :- ");
		       amt=sc.nextFloat();
		       //now deposit amount to that perticuler account
		       String hasDone=null;
		       for(BankAccount bnk:accounts) {
		    	   if(bnk.getAccNumber().equals(desc)) {
		    		   bnk.setAmt(amt,"");
		    		   System.out.println(" Money Deposited Succesfully!!!!!!!!");
		    		   hasDone="done";
		    	   }//if
		    	   else if(hasDone!="done") {     //both are not matches then they have diff hashcode  so i used that 
		    		   System.out.println("Please try with Correct with Account Number ");
		    	   }//else
		       }//for
	}//depositMoney
}//class
