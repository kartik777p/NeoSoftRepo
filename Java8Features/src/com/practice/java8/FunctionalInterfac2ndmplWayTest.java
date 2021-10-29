// 2.By using annonyms inner class

package com.practice.java8;

public class FunctionalInterfac2ndmplWayTest{

	public static void main(String[] args) {
	 IShowAble is=new IShowAble() {
			@Override
			public void show() {
				System.out.println("This is Annonymus inner class based Impl");
			}
	}; //line 8 end here
	//we have to call that method
	is.show();
	}//main
}//class
