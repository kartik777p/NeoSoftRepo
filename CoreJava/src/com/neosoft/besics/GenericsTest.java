package com.neosoft.besics;

public class GenericsTest {

	public static void main(String[] args) {
		System.out.println("------------------- for TestGen1 ---------------------------------");
		//for Int
		 TestGen1<Integer> intObj=new TestGen1(1000);
		 System.out.println(intObj.getObj());
		 
		 //for String
       TestGen1<String> stringObj=new TestGen1("java");   //if we pass int vlue err will come
       System.out.println(stringObj.getObj());
       System.out.println();
       System.out.println("------------------- for TestGen2 (key, valeu) ---------------------------------");
       TestGen2<String, Integer> strIntObj=new TestGen2("kp", 24);   //key-String  Value-Int
       System.out.println(stringObj.toString());
       TestGen2<Integer, Double> intDblObj=new TestGen2(8,1.8);     //key-Int Value=Double
       System.out.println(stringObj.toString());
       System.out.println();
       System.out.println("------------------- for TestGen3 (Generic type Method  ---------------------------------");
       TestGen3.getGeneric(1234);
       TestGen3.getGeneric("Kartik");
	}//main
}//class



//another class 1
class TestGen1<T>{
	T obj;
	 //cons 
	 public TestGen1(T obj) {
		this.obj=obj;
	}
	 //getters
	public T getObj() {
		return obj;
	}
	 
}
//another class 2
class TestGen2<T,U>{
	 T obj1;
	 U obj2;
	 //cons
	public TestGen2(T obj1, U obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	 //toString
	@Override
	public String toString() {
		return "TestGen2 [obj1=" + obj1 + ", obj2=" + obj2 + "]";
	}
}

//another class 3
class TestGen3{
	 //generic method
	public  static <T> void getGeneric(T element) {
		System.out.println(element.getClass().getName()+"--"+element);
	}
}