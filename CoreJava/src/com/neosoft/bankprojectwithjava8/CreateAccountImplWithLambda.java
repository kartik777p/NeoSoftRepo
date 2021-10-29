package com.neosoft.bankprojectwithjava8;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;



public class CreateAccountImplWithLambda {
	static ArrayList<BankAccount> accounts=new ArrayList<>();
	//static getter method
	public static ArrayList<BankAccount> getAccounts() {
		return accounts;
	}
	
	//non static method
	public static  void createAccount1() {
		Scanner sc = null;
		String accNo,name, addrs, mono, uname, pass, type = null;
		float initDep, amount = 0.0f;
		BankAccount acc=null;
		ObjectOutputStream oos=null;
		String outFile=null;

		// now gather values from end usr
		sc = new Scanner(System.in); 
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("------------Create Account Page ------------");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("Enter Account Number  of the Customer :- ");
		accNo=sc.next();
		System.out.println("Enter Name of the Customer :- ");
		name=sc.next();
		System.out.println("Enter Adress of the Customer :- ");
		addrs=sc.next();
		System.out.println("Enter MobileNumber of the Customer :- ");
		mono=sc.next();
		System.out.println("Enter username for the Customer :- ");
		uname=sc.next();
		/*System.out.println("Enter Password for  the Customer :- ");
		pass=sc.next();
		*/
		System.out.println("Enter Password for  the Customer :- ");
		pass=sc.next();
		while (!pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$")) {
			System.out.println("Invalid Password ! Password Must Contains Alphanumeric with Atleast one Special Symboll");
			System.out.print("Please Enter  Strong Password again :");
			pass = sc.next();
		}
		System.out.println("Enter Initial deposit amount of the Customer :- ");
		initDep=sc.nextFloat();
		System.out.println("Enter type of th Acount for  the Customer :-");
		type=sc.next();
		//store that values to to Bankaccount class
		acc=new BankAccount(accNo,name, addrs, mono, uname, pass, initDep, type);
		//now add this object to list
		accounts.add(acc);
		//now add account  to file 
		 outFile="Resources/AccountDetails.txt";  //location
		 try {
		oos=new ObjectOutputStream(new FileOutputStream(outFile));
		//now add account obj to file 
		   for(BankAccount bnkAcc: accounts) {
			   oos.writeObject(bnkAcc);
		   }//for
		 }catch (Exception e) {
			e.printStackTrace();
		}//catch
		System.out.println("Account Created Sucesfully !!!!!!!!!!!!!");
	}
	
	
	public void createAccount() {
		System.out.println("CreateAccountImplWithLambda.createAccount()");
		ICreateAccount ica=CreateAccountImplWithLambda::createAccount1 ;
		//call method
		ica.createAccount();
		System.out.println("CreateAccountImplWithLambda.createAccount()");
		
		
	/*	ICreateAccount ica=null;
		ica=()->{
			System.out.println("CreateAccountImplWithLambda.createAccount()");
			Scanner sc = null;
			String accNo,name, addrs, mono, uname, pass, type = null;
			float initDep, amount = 0.0f;
			BankAccount acc=null;
			ObjectOutputStream oos=null;
			String outFile=null;

			// now gather values from end usr
			sc = new Scanner(System.in); 
			System.out.println("-------------------------------------------------------------------------------------------------------");
			System.out.println("------------Create Account Page ------------");
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.println("Enter Account Number  of the Customer :- ");
			accNo=sc.next();
			System.out.println("Enter Name of the Customer :- ");
			name=sc.next();
			System.out.println("Enter Adress of the Customer :- ");
			addrs=sc.next();
			System.out.println("Enter MobileNumber of the Customer :- ");
			mono=sc.next();
			System.out.println("Enter username for the Customer :- ");
			uname=sc.next();
			/*System.out.println("Enter Password for  the Customer :- ");
			pass=sc.next();
			
			System.out.println("Enter Password for  the Customer :- ");
			pass=sc.next();
			while (!pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$")) {
				System.out.println("Invalid Password ! Password Must Contains Alphanumeric with Atleast one Special Symboll");
				System.out.print("Please Enter  Strong Password again :");
				pass = sc.next();
			}
			System.out.println("Enter Initial deposit amount of the Customer :- ");
			initDep=sc.nextFloat();
			System.out.println("Enter type of th Acount for  the Customer :-");
			type=sc.next();
			//store that values to to Bankaccount class
			acc=new BankAccount(accNo,name, addrs, mono, uname, pass, initDep, type);
			//now add this object to list
			accounts.add(acc);
			//now add account  to file 
			 outFile="Resources/AccountDetails.txt";  //location
			 try {
			oos=new ObjectOutputStream(new FileOutputStream(outFile));
			//now add account obj to file 
			   for(BankAccount bnkAcc: accounts) {
				   oos.writeObject(bnkAcc);
			   }//for
			 }catch (Exception e) {
				e.printStackTrace();
			}//catch
			System.out.println("Account Created Sucesfully !!!!!!!!!!!!!");
		};//lambda end    
		*/
	}//method
}//class
