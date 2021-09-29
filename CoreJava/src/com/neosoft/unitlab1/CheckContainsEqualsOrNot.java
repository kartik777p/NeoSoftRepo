package com.neosoft.unitlab1;

public class CheckContainsEqualsOrNot {

	public static void main(String[] args) {
		String s1="Welcome to neosoft";
		String s2="Welcome to neosoft";
		String s3="welcome to java";
		
		//check both (s1 and s2) are equals are not using equals method
		if(s1.equalsIgnoreCase(s2))
			System.out.println("String content is Same ");
		else
			System.out.println("String content is diffarent");
	
	if(s1.equalsIgnoreCase(s3))
		System.out.println("String content is Same ");
	else
		System.out.println("String content is diffarent");
	System.out.println("------------------------------------------------------------");
   
	//check both obj is pointing to same obj or  not
	if(s1==s2) 
		System.out.println("S1 and S2 is Poining to Same object ");
	else 
		System.out.println("S1 and S2 is Not Poining to Same object ");
	
	if(s1==s3) 
		System.out.println("S1 and S3 is Poining to Same object ");
	else 
		System.out.println("S1 and S3 is Not Poining to Same object ");
	
	
	}//main
		
}//class
