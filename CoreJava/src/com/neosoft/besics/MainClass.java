package com.neosoft.besics;

 class Book {
	private int bid;
	private String bName;
	private float cost;

	// cons
	public Book(int bid, String bName, float cost) {
		this.bid = bid;
		this.bName = bName;
		this.cost = cost;
	}

	public int getBid() {
		return bid;
	}

	public String getbName() {
		return bName;
	}

	public float getCost() {
		return cost;
	}
}


public class MainClass{
	public Book createObject(int bid,String bName, float cost) {
		Book b1=new Book(bid,bName,cost);
		return b1;
	}
	public void displayDetails(Book b1) {
		System.out.println(b1.getBid());
		System.out.println(b1.getbName());
		System.out.println(b1.getCost());
		
	}
	public static void main(String[] args) {
		    MainClass main= new MainClass();
		    Book b1=main.createObject(1," java", 200);
		    main.displayDetails(b1);
	}
}
