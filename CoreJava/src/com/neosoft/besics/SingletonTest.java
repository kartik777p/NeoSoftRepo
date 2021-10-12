package com.neosoft.besics;

public class SingletonTest {

	public static void main(String[] args) {
		//obj1
		 Singleton s1=Singleton.getInstance();
		 Singleton s2=Singleton.getInstance();
		 Singleton s3=Singleton.getInstance();
		 //chck hashcode
		 System.out.println("Hashcode of s1="+s1.hashCode()+" \t Hashcode of s2="+s2.hashCode()+" \t Hashcode of s3="+s3.hashCode());
	}//method
}//class

//class 
class Singleton{
	//
	private static  Singleton INSTANCE;
	//member
	public String db_name="my_DB";
	//cons
	private Singleton() {
		System.out.println("private cons");
	}
	//static factory method
	public static Singleton getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new Singleton();			
		}//if 
		return INSTANCE;
	}//method
}//class
