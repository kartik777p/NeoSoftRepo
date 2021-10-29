// 2.By using annonyms inner class

package com.practice.java8;

public class FunctionalInterfac4rthImplWayTest{
	
	//static method 
	public static void showtext1() {
		System.out.println("this is Static method ref type Impl of Functional Interface ");
	}
	//non-static method
	public  void showtext2() {
		System.out.println("this is Non-Static method ref type Impl of Functional Interface ");
	}
	//cons
	public FunctionalInterfac4rthImplWayTest() {
		System.out.println("this is Constuctor  ref type Impl of Functional Interface ");
	 }

	public static void main(String[] args) {
	 //static method Referance 
		IShowAble is1=FunctionalInterfac4rthImplWayTest::showtext1;  //no need of ()  
		//call method
		is1.show();
		System.out.println("-----------------------------------------------------------------------------------------");
		//Non-Static Method ref    (1st comment the cons) if you have defined allready otherwise that msg will come at the time of obj creation
		//Create the Object of Given clas which have NSM
		FunctionalInterfac4rthImplWayTest test=new FunctionalInterfac4rthImplWayTest();
		IShowAble is2=test::showtext2;    //we have to acess through Object
		//call method
		is2.show();
		System.out.println("-----------------------------------------------------------------------------------------");
		//Constuctor meth Ref  (remove comment now of the cons and write some msg)
		IShowAble is3=FunctionalInterfac4rthImplWayTest::new;  //bcz that cons is there in FunctionalInterfac4rthImplWayTest(class) and new create call cons 
		//call method
		is3.show();
	}//main
}//class
