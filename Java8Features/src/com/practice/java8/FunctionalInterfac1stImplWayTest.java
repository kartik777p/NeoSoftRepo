// 1.By createing Seprate imp class by Overriding that method

package com.practice.java8;

public class FunctionalInterfac1stImplWayTest implements IShowAble {
	
	@Override
	public void show() {
		System.out.println("FunctionalInterfacFirstImplWayTest.show()");
	}
	
	public static void main(String[] args) {
		//create this class object
		FunctionalInterfac1stImplWayTest test=new FunctionalInterfac1stImplWayTest();
		//call overriden method
		test.show();

	}//main
}//class
