package com.neosoft.besics;

public class CloneTest {

	public static void main(String[] args)throws CloneNotSupportedException {
		 //create 1st obj of IPhone13
		IPhone13 iphone13=new IPhone13(198,6.6,17.8);
		//clone that Object
		IPhone13 iphone13_1=(IPhone13)iphone13.clone();     //handle of throw exception
		IPhone13 iphone13_2=(IPhone13)iphone13.clone();     //handle of throw exception
		IPhone13 iphone13_3=(IPhone13)iphone13.clone();     //handle of throw exception
		IPhone13 iphone13_4=(IPhone13)iphone13.clone();     //handle of throw exception
		IPhone13 iphone13_5=(IPhone13)iphone13.clone();     //handle of throw exception
		 System.out.println(iphone13_4.height);
	}//main
}//class

//class iPhone13
class IPhone13 implements Cloneable{
	double weight;
	double height;
	double width;
	//cons
	public IPhone13(double weight, double height, double width) {
		this.weight = weight;
		this.height = height;
		this.width = width;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
