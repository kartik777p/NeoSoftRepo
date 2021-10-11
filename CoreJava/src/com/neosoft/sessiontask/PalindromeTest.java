package com.neosoft.sessiontask;

import java.util.Scanner;

public class PalindromeTest {

	public static void main(String[] args) {
		 Scanner sc=null;
		 sc=new Scanner(System.in);
		 System.out.println("Enter a number::");
		 int no=sc.nextInt();
		 int temp=no;
		 int rev=0,r;
		 
		 while(no>0) {
			 r=no%10;      //4 5 4
			 rev=(rev*10)+r;   //4  45 454
			 no=no/10;     //45  4  0
		 }
		 
		 if(temp==rev) {
			 System.out.println("Given no is palindrome!");
		 }
		 else {
			 System.out.println("Given no is not palindrome");
		 }
		 
		

	}

}
