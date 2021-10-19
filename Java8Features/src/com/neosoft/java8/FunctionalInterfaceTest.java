package com.neosoft.java8;


//functional interface
@FunctionalInterface
interface Addiction{
 
	public int add(int n1,int n2,int n3);
}


public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		//write lambda here
		Addiction add= (num1,num2,num3) ->{
			return num1+num2+num3;
		};
        //call lambda
		System.out.println("Addiction is :- "+add.add(100,200, 200));
	}

}
