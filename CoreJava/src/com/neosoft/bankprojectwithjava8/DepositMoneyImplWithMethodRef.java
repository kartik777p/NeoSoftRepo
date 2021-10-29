package com.neosoft.bankprojectwithjava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class DepositMoneyImplWithMethodRef {
	
	private static ArrayList<BankAccount> accounts=CreateAccountImplWithLambda.getAccounts(); 
	
	//non-static method ref
    public void depositMoney1() {
        Scanner sc=null;
	   // boolean flag=false;
	    String desc[]=new String[1];
	     String desc1=null;
	    float amt=0.0f;
	    float[] amtarr=new float[1];
	    boolean[] flag= {false};
	      sc=new Scanner(System.in);
	      System.out.println("--------------------------------------------------------------------");
	      System.out.println(" Deposit Money Page ");
	      System.out.println("--------------------------------------------------------------------");
	      System.out.println();
	      System.out.println("Enter Account Number Recipient person :- ");
	       desc1=sc.next();
	       desc[0]= desc1;
	       System.out.println("Enter Amount which you want to Deposit ");
	       amt=sc.nextFloat();
	       amtarr[0]=amt;
	     //  String str=null;  //
	      List<BankAccount> filtAccs=accounts.stream().filter(acc -> acc.getAccNumber().equalsIgnoreCase(desc[0])).collect(Collectors.toList());
	       //eterate
	       filtAccs.forEach(acc->{
	    	   //make flag as true
	    	   flag[0]=true;
	    	   acc.setAmt(amtarr[0],"");
    		   System.out.println(" Money Deposited Succesfully!!!!!!!!");
	       });
	       if(flag[0]==false) {
	    	   try {
	    	   throw new AccountNotFoundException("Account Not Found to Deposit Money......Please Try with Correct Account Number");
	       }catch (AccountNotFoundException e) {
			e.printStackTrace();
		}//catch
	       }//if
    }
	       
	       
//	       //check account number is present or not
//	       for(BankAccount acc:accounts) {
//	    	   if(acc.getAccNumber().equalsIgnoreCase(desc)) {
//	    		    System.out.println(" \n \t \t  Account Found \t \t  ");
//	    		    str="found";
//	    	   }//if
//	    	   else if(str!="found") {
//	    		   try {
//	    		   throw new  AccountNotFoundException("No account for the given Acc Number !!! please enter Correct Account Number and try again "); 
//	    		   }//try
//	    		   catch (AccountNotFoundException anfe) {
//					anfe.printStackTrace();
//				}//catch
//	    		  return ; //return controll
//	    	   }//else
//	       }//for
//	       System.out.println();
//	       System.out.println("Enter Amount which you have to Desosit  :- ");
//	       amt=sc.nextFloat();
//	       //now deposit amount to that perticuler account
//	       String hasDone=null;
//	       for(BankAccount bnk:accounts) {
//	    	   if(bnk.getAccNumber().equals(desc)) {
//	    		   bnk.setAmt(amt,"");
//	    		   System.out.println(" Money Deposited Succesfully!!!!!!!!");
//	    		   hasDone="done";
//	    	   }//if
//	    	   else if(hasDone!="done") {     //both are not matches then they have diff hashcode  so i used that 
//	    		   System.out.println("Please try with Correct with Account Number ");
//	    	   }//else
//	       }//for
//
	//}//depositMoney1
	
    
	public void depositMoney() {
		IDepositMoney idm=null;
		DepositMoneyImplWithMethodRef dmwmf=null;
		dmwmf=new DepositMoneyImplWithMethodRef();
		idm=dmwmf::depositMoney1;  //non-static method ref
		//call method
		idm.depositMoney();
	}//depositMoney
}//class 
