package com.neosoft.java8;

import java.util.StringJoiner;

public class StringJoinerTest {

	public static void main(String[] args) {
		//create 1st object
		StringJoiner joiner=new StringJoiner("-","[","]");  //here (seprator,prefix,suffix) eg :- [kp-np]
		//add values to joiner
		joiner.add("kartik");
		joiner.add("Shubh");
		joiner.add("maddy");
		joiner.add("Mahesh");
		//print Joiner
		System.out.println(joiner);
		System.out.println("------------------------------------------------------------------------------");
		//create 2nd Object
		StringJoiner joiner2=new StringJoiner(": ", "[", "]");
		//add values to joiner
		joiner2.add("kartik");
		joiner2.add("Shubh");
		joiner2.add("maddy");
		joiner2.add("Mahesh");
		//print Joiner
		System.out.println(joiner2);
		System.out.println("---------------Merging of two Joiners----------------------");
		//we can marge 1st and 2nd Object also
		System.out.println(joiner.merge(joiner2));
		
	}

}
