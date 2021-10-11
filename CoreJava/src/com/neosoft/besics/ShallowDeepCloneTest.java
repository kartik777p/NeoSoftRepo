package com.neosoft.besics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ShallowDeepCloneTest {

	public static void main(String[] args) {
		 int[] arr= {10,20,30,40};
   //create shallow obj
	   Shallow s=new Shallow(arr);
	   //call method
	   s.showData();       //10 20 30 40 
	   //modfy arry
	   arr[0]=100;        //arr and s.data have some ref 
	   s.showData();    //(Same memory ref) modify value bcz both have same hashcode  100 20 30 40 
	   
	   System.out.println("------------deep ----------------------------");
	   int[] arr1= {10,20,30,40};
	   Deep d=new Deep(arr1);
	   d.showData();
	   //modify
	   arr1[0]=500;
	   d.showData();
	}

}

//shallow copy
class Shallow{
	private int[] data;
	//cons

	public Shallow(int[] data) {
		this.data = data;
	}
	public  void showData() {
		System.out.println(Arrays.toString(data));
	}
}

 class Deep{
	 private int[] data;
		//cons
		public Deep(int[] data) {
			this.data = new int[data.length];
			for(int i=0;i<data.length;i++) {
				this.data[i]=data[i];  //deep
			}
		}
		public  void showData() {
			System.out.println(Arrays.toString(data));
		}
 }
