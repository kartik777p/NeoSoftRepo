package com.neosoft.besics;


public class MyThredByRunnable  implements Runnable{

	@Override
	public   void run() {
		for(int i=1;i<=100;i++) {
			System.out.println("From run :-"+i);
		}	
	}
	
	public static void main(String[] args) {
		MyThredByRunnable myRun=new MyThredByRunnable();
		//we can not directly call run method like this
		//myRun.start(); //bcz there is no run metod in our class or runnble interface
		//we have to create one Predefined thread class obj and pass our obj as a args cons
		Thread th=new Thread(myRun);
		//call start method
		th.start();
		
		for(int i=100;i>0;i--) {
			System.out.println("From main :- "+i);
		}
		
		
	}

}
