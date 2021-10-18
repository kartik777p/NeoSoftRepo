package com.neosoft.bankproject;

import java.util.ArrayList;
import java.util.Scanner;

public class FindAccountsAndUserDetails {
	private static ArrayList<BankAccount> accounts = CreateAccount.getAccounts();
    
	/************************************************OPTION MENUS FOR SEARCH ***********************************************************************************/
    public void ShowSearchMenus() {
    	Scanner sc = null;
		int choiseNo = 0;
		sc = new Scanner(System.in);
		String choiseFlag = null;
		
		System.out.println("\t\t\t\t -----------------------------------------------------------------\t\t");
		System.out.println("\t \t \t \t \t \t  On which Details You want to Search ACCOUNT/USER   ");
		System.out.println("\t\t\t\t -----------------------------------------------------------------\t\t");
		// SHOW MENU
		System.out.println("\t\t\t\t\t\t 1. Search Based On Name ");
		System.out.println("\t\t\t\t\t\t 2. Search Based On MobileNumber ");
		System.out.println("\t\t\t\t\t\t 3. Search Based On Address  ");
		System.out.println("\t\t\t\t\t\t 4. Search Based On UserName ");
		System.out.println("\t\t\t\t\t\t 5. Search Based On Account Type ");
		
		System.out.println("\t\t\t\t\t\t 6. Search Based On Initial Charecters  ");
		
		System.out.println("\t\t\t\t\t\t 7. Exit ");
		System.out.println();
		System.out.println("\t\t\t\t\t\t Enter Your Choise  - ");
		choiseNo = sc.nextInt();

		switch (choiseNo) {
		//Name
		case 1:
			searchByName();
			break;
			//MobileNumber
		case 2:
			searchByMobileNumber();
			break;
			//Address
		case 3:
			searchByAddress();
			break;
			//userName
		case 4:
			searchByUserName();
			break;
			//Account Type
		case 5:
			searchByAccountType();
			break;
			//FindUserby 1st chars
		case 6:
			findUserByItsfirstChars();
			break;
		case 7:
			System.out.println("Thank you .......for Utilizing our Service");
			break;
		}// switch

    }//ShowSearchMenus
    /************************************************FIND USER BY ITS INITIAL CHARECTERS  ***********************************************************************************/
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
	
    /************************************************SEARCH BY NAME***********************************************************************************/
    public void searchByName() {
    	 Scanner sc=null;
         String uName=null;
         sc=new Scanner(System.in);
         System.out.println("Enter Customer Name ");
         uName=sc.next();
         for(BankAccount bkacc:accounts) {
         	  if(bkacc.getName().startsWith(uName)) {
         		System.out.println("\t The account details for the customer "+bkacc.getName().toUpperCase()+" is :- ");
		    	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    	System.out.println("\t Account Number :-  \t\t\t\t"+bkacc.getAccNumber());
		    	 System.out.println("\t Name :- \t\t\t\t "+bkacc.getName());
		    	 System.out.println("\t Adress :- \t\t\t \t"+bkacc.getAdd());
		    	 System.out.println("\t MobileNumber :- \t\t \t\t"+bkacc.getCno());
		    	 System.out.println("\t UserName  :-  \t\t\t\t"+bkacc.getUname());
		    	 System.out.println("\t Password :-  \t\t\t\t"+bkacc.getPwd());
		    	 System.out.println("\t Amount :-  \t\t\t\t"+bkacc.getAmt());
		    	 System.out.println("\t Account Type :- \t\t \t\t"+bkacc.getType());
		    	 System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
         	  }//if
         	  else {
         		 try {
       			 throw new UserNotFoundException("User not Found to SearchBy Name");
       		 }catch (UserNotFoundException unfe) {
       			 unfe.printStackTrace();
				}//catch
         		 }//else
         }//for
    }//searchByName
    /************************************************SEARCH BY MOBILENUMBER***********************************************************************************/
    public void searchByMobileNumber() {
    	 Scanner sc=null;
         String mobileNumber=null;
         sc=new Scanner(System.in);
         System.out.println("Enter Customer Mobile Number  ");
         mobileNumber=sc.next();
         for(BankAccount bkacc:accounts) {
         	  if(bkacc.getCno().startsWith(mobileNumber)) {
         		System.out.println("\t The account details for the customer "+bkacc.getName().toUpperCase()+" is :- ");
		    	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    	System.out.println("\t Account Number :-  \t\t\t\t"+bkacc.getAccNumber());
		    	 System.out.println("\t Name :- \t\t\t\t "+bkacc.getName());
		    	 System.out.println("\t Adress :- \t\t\t \t"+bkacc.getAdd());
		    	 System.out.println("\t MobileNumber :- \t\t \t\t"+bkacc.getCno());
		    	 System.out.println("\t UserName  :-  \t\t\t\t"+bkacc.getUname());
		    	 System.out.println("\t Password :-  \t\t\t\t"+bkacc.getPwd());
		    	 System.out.println("\t Amount :-  \t\t\t\t"+bkacc.getAmt());
		    	 System.out.println("\t Account Type :- \t\t \t\t"+bkacc.getType());
		    	 System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
         	  }//if
         	  else {
         		 try {
       			 throw new UserNotFoundException("No Record Found For The Given Mobile Number");
       		 }catch (UserNotFoundException unfe) {
       			 unfe.printStackTrace();
				}//catch
         		 }//else
         }//for
    }//searchByMobileNumber
    /************************************************SEARCH BY USERNAME***********************************************************************************/
    public void searchByUserName() {
    	Scanner sc=null;
        String userName=null;
        sc=new Scanner(System.in);
        System.out.println("Enter Customer Username  ");
        userName=sc.next();
        for(BankAccount bkacc:accounts) {
        	  if(bkacc.getUname().startsWith(userName)) {
        		System.out.println("\t The account details for the customer "+bkacc.getName().toUpperCase()+" is :- ");
		    	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    	System.out.println("\t Account Number :-  \t\t\t\t"+bkacc.getAccNumber());
		    	 System.out.println("\t Name :- \t\t\t\t "+bkacc.getName());
		    	 System.out.println("\t Adress :- \t\t\t \t"+bkacc.getAdd());
		    	 System.out.println("\t MobileNumber :- \t\t \t\t"+bkacc.getCno());
		    	 System.out.println("\t UserName  :-  \t\t\t\t"+bkacc.getUname());
		    	 System.out.println("\t Password :-  \t\t\t\t"+bkacc.getPwd());
		    	 System.out.println("\t Amount :-  \t\t\t\t"+bkacc.getAmt());
		    	 System.out.println("\t Account Type :- \t\t \t\t"+bkacc.getType());
		    	 System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        	  }//if
        	  else {
        		 try {
      			 throw new UserNotFoundException("No Record Found For The Given USERNAME");
      		 }catch (UserNotFoundException unfe) {
      			 unfe.printStackTrace();
				}//catch
        		 }//else
        }//for
    }//searchByUserName
    /************************************************SEARCH BY ACCOUNT TYPE ***********************************************************************************/
    public void searchByAccountType() {
    	Scanner sc=null;
        String accType=null;
        sc=new Scanner(System.in);
        System.out.println("Enter Customer Account Type   ");
        accType=sc.next();
        for(BankAccount bkacc:accounts) {
        	  if(bkacc.getType().startsWith(accType)) {
        		System.out.println("\t The account details for the customer "+bkacc.getName().toUpperCase()+" is :- ");
		    	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    	System.out.println("\t Account Number :-  \t\t\t\t"+bkacc.getAccNumber());
		    	 System.out.println("\t Name :- \t\t\t\t "+bkacc.getName());
		    	 System.out.println("\t Adress :- \t\t\t \t"+bkacc.getAdd());
		    	 System.out.println("\t MobileNumber :- \t\t \t\t"+bkacc.getCno());
		    	 System.out.println("\t UserName  :-  \t\t\t\t"+bkacc.getUname());
		    	 System.out.println("\t Password :-  \t\t\t\t"+bkacc.getPwd());
		    	 System.out.println("\t Amount :-  \t\t\t\t"+bkacc.getAmt());
		    	 System.out.println("\t Account Type :- \t\t \t\t"+bkacc.getType());
		    	 System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        	  }//if
        	  else {
        		 try {
      			 throw new UserNotFoundException("No Record Found For The Given AccountType ");
      		 }catch (UserNotFoundException unfe) {
      			 unfe.printStackTrace();
				}//catch
        		 }//else
        }//for
    }//searchByAccountType
    /************************************************SEARCH BY ACCOUNT ADDRESS  ***********************************************************************************/
    public void searchByAddress() {
    	Scanner sc=null;
        String addrs=null;
        sc=new Scanner(System.in);
        System.out.println("Enter Customer Address   ");
        addrs=sc.next();
        for(BankAccount bkacc:accounts) {
        	  if(bkacc.getAdd().startsWith(addrs)) {
        		System.out.println("\t The account details for the customer "+bkacc.getName().toUpperCase()+" is :- ");
		    	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    	System.out.println("\t Account Number :-  \t\t\t\t"+bkacc.getAccNumber());
		    	 System.out.println("\t Name :- \t\t\t\t "+bkacc.getName());
		    	 System.out.println("\t Adress :- \t\t\t \t"+bkacc.getAdd());
		    	 System.out.println("\t MobileNumber :- \t\t \t\t"+bkacc.getCno());
		    	 System.out.println("\t UserName  :-  \t\t\t\t"+bkacc.getUname());
		    	 System.out.println("\t Password :-  \t\t\t\t"+bkacc.getPwd());
		    	 System.out.println("\t Amount :-  \t\t\t\t"+bkacc.getAmt());
		    	 System.out.println("\t Account Type :- \t\t \t\t"+bkacc.getType());
		    	 System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        	  }//if
        	  else {
        		 try {
      			 throw new UserNotFoundException("No Record Found For The Given Address ");
      		 }catch (UserNotFoundException unfe) {
      			 unfe.printStackTrace();
				}//catch
        		 }//else
        }//for
    }//searchByAccountType
}// class
