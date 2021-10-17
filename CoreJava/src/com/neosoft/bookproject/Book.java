package com.neosoft.bookproject;

import java.io.Serializable;
import java.util.Arrays;

public class Book  implements Serializable{
    private String bid;
    private String bookNam;
    private float bookPrice;
    private String[] authoresName;
    //cons
    public Book() {
		// TODO Auto-generated constructor stub
	}
	//param cons
    public Book(String bid, String bookNam, float bookPrice, String[] authoresName) {
		super();
		this.bid = bid;
		this.bookNam = bookNam;
		this.bookPrice = bookPrice;
		this.authoresName = authoresName;
    }//paramcons
    //getters nd Setters
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBookNam() {
		return bookNam;
	}
	public void setBookNam(String bookNam) {
		this.bookNam = bookNam;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String[] getAuthoresName() {
		return authoresName;
	}
	public void setAuthoresName(String[] authoresName) {
		this.authoresName = authoresName;
	}
    //toString
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bookNam=" + bookNam + ", bookPrice=" + bookPrice + ", authoresName="
				+ Arrays.toString(authoresName) + "]";
	}//toString
}//class
