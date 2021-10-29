//  3.By using Lambda Expression

package com.practice.java8;

public class FunctionalInterfac3rdImplWayTest{

	public static void main(String[] args) {
		//1st
	     IShowAble is=()->{
	    	 System.out.println("This is lambda Expression based impl Normal way for 1 Args ");
	     };
	     //call method
	     is.show();
	     System.out.println("---------------------------------------------------------------------");
	     IShowAble is2=()->System.out.println("This is lambda Expression based impl shortest way for 1 args ");
	     //call method
	     is2.show();
	}//main
}//class
