package com.neosoft.bankproject;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountTestConsoleProject {

	// shows menus 
	public void ShowMenus() {
		ArrayList<BankAccount> accounts=CreateAccount.getAccounts();
		Scanner sc=null;
		int choiseNo=0;
		CreateAccount acc=new CreateAccount();
		String status=null;
		//show menu
	     sc = new Scanner(System.in);
	     do {
	    	 System.out.println();
		System.out.println("-----------------------------");
		System.out.println("BANK   OF  "+BankAccount.getBankName().toUpperCase()); //convert bank name to uppercase 
		System.out.println("-----------------------------");
		System.out.println();

		System.out.println("1. Register Account");
		System.out.println("2.User  Login");
		System.out.println("3. Update accounts");
		System.out.println("4. Deposit Money ");
		
		System.out.println("5. Transfer money");
		System.out.println("6. See Lists of accounts ");
		System.out.println("7.Search  user/Acoount ");
		System.out.println("8. Exit");
		System.out.println();
		//get  user choise and show option for their choise
      System.out.println("Enter Your Choise Number");
      choiseNo=sc.nextInt();
      switch(choiseNo){   
      //create Account
      case 1: acc.createAccount();
                 break;
      //login
      case 2:new UserLogin().login();
                   break; 
      //update account
      case 3:new UpdateUser().update();
                      break;
                      //Deposit money 
         case 4:new DipositMoney().depositMoney();
                      break;
                      //transfer money 
      case 5:new TransferMoney().tranferMoney();
                   break;
                   //show all accounts
      case 6:acc.showAccount();
                   break;
                   //search user/Account
      case 7:new FindCustomerByUsingFirstCharsOfHisName().findUserByItsfirstChars();
                    break;
             //exit 
      case 8: System.out.println("Thank you for Utilizing our Service ");
      					break;
      }//switch
      System.out.println();
      System.out.println("Do you want to Continue - ");
       System.out.println("Say Yes/No");
       status=sc.next(); 
       if(status.equalsIgnoreCase("no")) {
    	   System.out.println("Thanks For Takking our Service ");
       }
	 }while(status.equalsIgnoreCase("yes"));
	}//method

	public static void main(String[] args) {
		Scanner sc = null;
		String bName = null;
		BankAccountTestConsoleProject test=null;
		
		// create scanner
			sc = new Scanner(System.in);
			// get bankName from user
			System.out.println("Enter Bank Name :- ");
			bName=sc.next();
			//set Name to  BankAccount
			BankAccount.setBankName(bName);
			//now show bankMenu to EndUser
			test=new BankAccountTestConsoleProject();
		     test.ShowMenus();
		     //close Sc here
		     sc.close();
	}//main
}//class
