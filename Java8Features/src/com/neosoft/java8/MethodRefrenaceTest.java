package com.neosoft.java8;

//functional interface
@FunctionalInterface
interface Showable{
	public void show();
}

@FunctionalInterface
interface Showable1{
	public void show1(String msg);

}

public class MethodRefrenaceTest {
	//static method
	public static void showText() {
		System.out.println("Hello..!!! i am a static method");
	} //static
	
	//non static method
	public void showtext2() {
		System.out.println("Hello..!!! i am a Non-Static  method");
	}//non-static
   //no param cons
   public MethodRefrenaceTest() {
}
	//cons param
	public MethodRefrenaceTest(String msg) {
		System.out.println(msg);
	}
   
	public static void main(String[] args) {
		
		System.out.println("--------------------Static method Refrence -----------------");
		//static method Refreance  on our class
		Showable s1=MethodRefrenaceTest::showText;   //no need of function brackets
		s1.show();       //  Hello..!!! i am a static method
		
		//method refarence on Thraed/runable class 
		Runnable r=MethodRefrenaceTest::showText;     //1st way
		new Thread(r).start();     
		new Thread(MethodRefrenaceTest::showText).start();    //static method refrence  2nd and short way
		//System.out.println();
	//--------------------------------Non Static -------------------------------------------------
		//create test class obj
		MethodRefrenaceTest test=new MethodRefrenaceTest();    //non static method ref on our class
		//give method ref
		Showable s2=test::showtext2;
		//call method
       s2.show();
       //predifened class ref
       new Thread(new MethodRefrenaceTest()::showtext2).start();    //non static method ref
       System.out.println();
      
       /*******************************Constuctor refrence***********************************************************/
       Showable1 s3=MethodRefrenaceTest::new;     //cons Refrence        s3 has cons logic now
       //call method     (here will give that logic to that method)
       s3.show1("welcome to java 8 ");      //0param cons has been called bcz of new with no param
	}
}
