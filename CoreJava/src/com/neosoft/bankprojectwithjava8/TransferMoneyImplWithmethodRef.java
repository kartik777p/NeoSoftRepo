package com.neosoft.bankprojectwithjava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;




public class TransferMoneyImplWithmethodRef{
  
	
	
	public void tranferMoney1(){
	 	ArrayList<BankAccount> accounts=CreateAccountImplWithLambda.getAccounts();
   		Scanner sc=null;
		String src,dest=null;
		 String[] destarr=new String[1];
		float rs=0.0f;
		//String srcStatus,destStatus=null;
		BankAccount srcAcc[]=new BankAccount[1];
		BankAccount destAcc[]=new BankAccount[1];
		//String srcAccNum=null;
		//String destAccNum=null;
		boolean srcStr=false;
		boolean destStc=false;
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Transfer Money Page ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println();
		
		sc=new Scanner(System.in);
		System.out.println("Enter Source Account Number ");
		src=sc.next();
		System.out.println("Enter Destination Account Number ");
		dest=sc.next();
		destarr[0]=dest;  //making them effectvly final
		 // source account verification
		List<BankAccount> filSrcAcc=accounts.stream().filter(acc -> acc.getAccNumber().equalsIgnoreCase(src)).collect(Collectors.toList());            //collect(Collectors.toList());
		filSrcAcc.stream().forEach(acc ->System.out.println("Source Account Found "));
		List<BankAccount> filDestAcc=accounts.stream().filter(acc -> acc.getAccNumber().equalsIgnoreCase(destarr[0])).collect(Collectors.toList());            //collect(Collectors.toList());
		filSrcAcc.stream().forEach(acc ->System.out.println("Destination Account Found "));
		//source
		 filSrcAcc.stream().forEach(acc->{
			 srcAcc[0]=acc;
//			 System.out.println(acc.getAccNumber());
//			 System.out.println(acc.getName());
//			 System.out.println("---------");
//			 System.out.println( srcAcc[0].getAccNumber());
//			 System.out.println( srcAcc[0].getName());
		 });
		 //destination
		 filDestAcc.stream().forEach(acc->{
			 destAcc[0]=acc;
//			 System.out.println(acc.getAccNumber());
//			 System.out.println(acc.getName());
		 });
		 System.out.println("Enter how much Amout you want to Transfer ");
		 rs=sc.nextFloat();
		if(srcAcc[0].getAmt()<=rs) {
			try {
			throw new InsufficientBalenceException("Insiccfient balence ");
			}catch (Exception e) {
				e.printStackTrace();
			}//catch
			//return controll 
			return;
		}//if
		
			//deposit money to dest account
			destAcc[0].setAmt(rs,"depo");
			//reduce money from src account
			float minusAcc=srcAcc[0].getAmt()-rs;
			srcAcc[0].setAmt(minusAcc,"with");
			System.out.println("Money Transfer Sucessfully!!!!!!!!!!!!!!");
	}
	
	public  void tranferMoney( ) {
	   	   ITransferMoney itm=new TransferMoneyImplWithmethodRef()::tranferMoney1;
	   	//call method
	   	itm.tranferMoney();
	}
}
