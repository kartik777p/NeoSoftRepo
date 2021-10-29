package com.neosoft.bankprojectwithjava8;

import java.util.ArrayList;
import java.util.Optional;


public class ShowAllUsers {
	static ArrayList<BankAccount> accounts=CreateAccountImplWithLambda.getAccounts();
	
	//method
	public void showAccount() {
		IShowAllUsers isau=null;
		Optional<BankAccount> op=null;
		boolean flag[]= {false};
		isau= ()->{       //lambda
			int size=0;
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Show Lists Of Accounts ");
			System.out.println("--------------------------------------------------------------------");
			//  op=Optional.ofNullable(accounts);
			if(accounts.size()!=0) {
				//use stream
				accounts.stream().forEach(bk -> {
					//make flag as true
					// flag=true;  Local variable flag defined in an enclosing scope must be final or effectively final
					flag[0]=true; //effectivly final 
					System.out.println("\t The account details for the customer "+bk.getName().toUpperCase()+" is :- ");
			    	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			    	System.out.println("\t Account Number :-  \t\t\t\t"+bk.getAccNumber());
			    	 System.out.println("\t Name :- \t\t\t\t "+bk.getName());
			    	 System.out.println("\t Adress :- \t\t\t \t"+bk.getAdd());
			    	 System.out.println("\t MobileNumber :- \t\t \t\t"+bk.getCno());
			    	 System.out.println("\t UserName  :-  \t\t\t\t"+bk.getUname());
			    	 System.out.println("\t Password :-  \t\t\t\t"+bk.getPwd());
			    	 System.out.println("\t Amount :-  \t\t\t\t"+bk.getAmt());
			    	 System.out.println("\t Account Type :- \t\t \t\t"+bk.getType());
			    	 System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
				});//for each
			}//if
			if(flag[0]==false){
				try {
				throw new AccountNotFoundException("Accounts not  found.... Please 1st Register and then Try....");
				}catch (AccountNotFoundException anfe) {
					anfe.printStackTrace();
				}//catch
			}//if
		};//LAMBDA END
		//call method
		isau.showAccount();
	}//method
} //class
