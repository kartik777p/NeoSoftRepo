package com.neosoft.bankprojectwithjava8;

import java.util.ArrayList;
import java.util.Scanner;


public class UpdateUserImplWithLambda {
	   ArrayList<BankAccount> accounts=CreateAccountImplWithLambda.getAccounts();
	   
	public void update() {
		IUpdateUser iu=null;
		iu=()->{
			Scanner sc = null;
			int choiseNo = 0;
			sc = new Scanner(System.in);
			System.out.println("--------------------------------------------------------------------");
			System.out.println(" Update BankDetails Page ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println();
			System.out.println("Which Of the Following  Details you Want to Update ");
			System.out.println("-----------------------------------------------------------------------------------------");

			System.out.println();

			System.out.println("1. Name");
			System.out.println("2. Address");
			System.out.println("3. Mobile Number");
			System.out.println("4. UserName ");
			System.out.println("5. Password ");
			System.out.println("6. Exit");
			
			System.out.println();
			// get user choise and show option for their choise
			System.out.println("Enter Your Choise Number");
			choiseNo = sc.nextInt();
			switch (choiseNo) {
			case 1:
				updateName();
				break;
			case 2:
				updateAddress();
				break;
			case 3:
				updateMobileNumber();
				break;
			case 4:
				updateUserName();
				break;
			case 5:
				updatePassword();
				break;

			case 6:
				System.out.println("Thank you .........................");
			}// switch

		}; //lamda
		//call method
		iu.update();
	}//menus
	/***********************************************************************************************************************************/
	public void updateName() {
		Scanner sc = null;
		String name = null;
		String accNo=null;
		boolean flag=false;
		sc = new Scanner(System.in);
		System.out.println("Enter a Account Number :- ");
		accNo=sc.next();
		System.out.println("Enter a new Name :- ");
		name = sc.next();
		for (BankAccount acc : accounts) {
			if(acc.getAccNumber().equalsIgnoreCase(accNo)) {
				//make flag as true
				flag=true;
			acc.setName(name);
			System.out.println("Name Updated Succesfully !!!!!!!!!!!!!!!!!!");
			}//if
		}//for
		if(flag==false) {
			try {
				throw new AccountNotFoundException("Account Not Found For The Given Account Number");
			}catch (Exception e) {
				e.printStackTrace();
			}//catch
		}//if
	}// updateName
	/*******************************************************************************************************************************************  */
	public void updateAddress() {
		Scanner sc = null;
		boolean flag=false;
		String accNo=null;
		String Address = null;
		sc = new Scanner(System.in);
		System.out.println("Enter a Account Number :- ");
		accNo=sc.next();
		System.out.println("Enter a new Address :- ");
		Address = sc.next();
		for (BankAccount acc : accounts) {
			if(acc.getAccNumber().equalsIgnoreCase(accNo)) {
			//make flag as true
			flag=true;
			acc.setAdd(Address);
			System.out.println("Address Updated Succesfully !!!!!!!!!!!!!!!!!!");
			}//if
		} // for
		if(flag==false) {
			try {
				throw new UserNotFoundException("User Not Found For The Account Number");
			}catch (Exception e) {
				e.printStackTrace();
			}//catch
		}//if
	}// update address
	/*******************************************************************************************************************************************  */
	public void updateMobileNumber() {
		Scanner sc = null;
		boolean flag=false;
		String accNo=null;
		String mobileNumber = null;
		sc = new Scanner(System.in);
		System.out.println("Enter a Account Number :- ");
		accNo=sc.next();
		System.out.println("Enter a new mobileNumber :- ");
		mobileNumber = sc.next();
		for (BankAccount acc : accounts) {
			if(acc.getAccNumber().equalsIgnoreCase(accNo))  {
				//make flag as true
				flag=true;
			acc.setCno(mobileNumber);
			System.out.println("mobileNumber Updated Succesfully !!!!!!!!!!!!!!!!!!");
			}//if
		} // for
		if(flag==false) {
			try {
				throw new UserNotFoundException("User Not Found For The Given Account Number");
			}catch (Exception e) {
				e.printStackTrace();
			}//catch
		}//if
	}// updateMobileNumber
	/*******************************************************************************************************************************************  */
	public void updateUserName() {
		Scanner sc = null;
		boolean flag=false;
		String accNo=null;
		String username = null;
		sc = new Scanner(System.in);
		System.out.println("Enter a Account Number :- ");
		accNo=sc.next();
		System.out.println("Enter a new username :- ");
		username = sc.next();
		for (BankAccount acc : accounts) {
			if(acc.getAccNumber().equalsIgnoreCase(accNo))  {
				//make flag as true
				flag=true;
			acc.setUname(username);
			System.out.println("username Updated Succesfully !!!!!!!!!!!!!!!!!!");
			}//if
		} // for
		if(flag==false) {
			try {
				throw new UserNotFoundException("User Not Found For The Account Number");
			}catch (Exception e) {
				e.printStackTrace();
			}//catch
		}//if
	}// updateUserName
	/*******************************************************************************************************************************************  */
	public void updatePassword() {
		Scanner sc = null;
		String accNo=null;
		boolean flag=false;
		String password = null;
		sc = new Scanner(System.in);
		System.out.println("Enter a Account Number :- ");
		accNo=sc.next();
		System.out.println("Enter a new password :- ");
		password = sc.next();
		for (BankAccount acc : accounts) {
			if(acc.getAccNumber().equalsIgnoreCase(accNo))  {
				//make flag as true
				flag=true;
			acc.setPwd(password);
			System.out.println("password Updated Succesfully !!!!!!!!!!!!!!!!!!");
			}//if
		} // for
		if(flag==false) {
			try {
				throw new UserNotFoundException("User Not Found For The Account Number");
			}catch (Exception e) {
				e.printStackTrace();
			}//catch
		}//if
	}// updatePassword

}
