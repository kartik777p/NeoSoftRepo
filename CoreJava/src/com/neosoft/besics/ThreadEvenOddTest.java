package com.neosoft.besics;

public class ThreadEvenOddTest  {

	public static void main(String[] args) {
		EvenThread even=new EvenThread();
		//pass cmd values to eventhread
		int n=Integer.parseInt(args[0]);
		//give values
		even.gatherNumber(n);
		try {
		even.start();
		Thread.sleep(100);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		//odd
		OddThread odd=new OddThread();
		odd.gatherNumber(n);
		try {
		odd.start();
		Thread.sleep(100);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//Even
class EvenThread extends Thread{
	int n;
	public void gatherNumber(int n) {
		this.n=n;
	}
	@Override
	public void run() {
		try {
		for(int i=11;i<=n;i++) {
			if(i%2==0) {
				System.out.print(" "+i);
			}
			
		}
	}//try
		catch (Exception e) {
		e.printStackTrace();
		}
	}
}

//Odd
class OddThread extends Thread{
	int n;
	public void gatherNumber(int n) {
		this.n=n;
	}
	@Override
	public void run() {
		try {
		for(int i=11;i<=n;i++) {
			if(i%2!=0) {
				System.out.print(" "+i);
			}
		}
	}//try
		catch (Exception e) {
		e.printStackTrace();
		}//catch
	}//method
}//class
