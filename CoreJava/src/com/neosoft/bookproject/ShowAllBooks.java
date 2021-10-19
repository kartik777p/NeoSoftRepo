package com.neosoft.bookproject;

import java.util.ArrayList;
import java.util.Arrays;

public class ShowAllBooks {
    
	public void showAllBooks() {
		 ArrayList<Book> books=null;
		 boolean flag=false;
		 //get the List of books
		 books=AddBook.getBookLists();
		 //now print that all books details
		// System.out.println(books.size());
		 if(books!=null) {   
			        System.out.println("\t\t\t\t -----------------------------------------------------");
			        System.out.println("\t\t\t\t\t\t Show Book Page  ");
			        System.out.println("\t\t\t\t -----------------------------------------------------");
		 for(Book bks :books) {
			 flag=true;
			      System.out.println("--------------------------------"+bks.getBookNam().toUpperCase()+" Book Details ------------------------------------");
			      System.out.println("\t \t Book id :: - \t\t\t\t\t\t\t \t\t\t\t\t"+bks.getBid());
			      System.out.println(" \t \t Book Name :: - \t\t\t\t\t\t\t\t\t\t\t"+bks.getBookNam());
			      System.out.println(" \t \tBook Price  :: - \t\t\t\t\t\t\t\t\t\t\t"+bks.getBookPrice());
			      System.out.println(" \t \tAuthors Names  :: - \t\t\t\t\t\t\t\t\t\t"+Arrays.toString(bks.getAuthoresName()));
		      }//for
		 }//if
		 if(flag!=true) {
			 System.out.println();
			    System.out.println(" \t \t  \t  \t No Books Found");
		 }
	}//showAllBooks
}//class
