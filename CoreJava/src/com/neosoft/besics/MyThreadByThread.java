package com.neosoft.besics;

public class MyThreadByThread extends Thread {
	
	//run
	public void run() {
		for(int i=1;i<=100;i++) {
			System.out.println("From run :-"+i);
		}
	}

	public static void main(String[] args) {
		//create obj of our class
		MyThreadByThread myth=new MyThreadByThread();
		//call start method to create new thread
		myth.start();
		//main logic
		for(int i=100;i>0;i--) {
			System.out.println("From main :- "+i);
		}

	}

}
