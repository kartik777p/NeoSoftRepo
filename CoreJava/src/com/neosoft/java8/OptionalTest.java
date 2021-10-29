package com.neosoft.java8;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		//create array having null values
		String arr[]=new String[5];
		 //System.out.println(arr[3].toLowerCase());  //gives us nullPoinerException bcz 3 location is null
	  arr[3]="kartik";
		Optional<String> checkNull=Optional.ofNullable(arr[3]); //if value present value give else empty optional 
		if(checkNull.isPresent())
			   System.out.println(arr[3].toUpperCase());
		else
			System.out.println("No element Present");
		System.out.println("-------------------------------------------------------------------");
		//using Lambda Expression   //ar[3] is there then print it to uppercase
		Optional.ofNullable(arr[3]).ifPresent(s -> System.out.println(s.toUpperCase()));
	}
}
