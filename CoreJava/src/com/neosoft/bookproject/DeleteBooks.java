package com.neosoft.bookproject;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteBooks {
	ArrayList<Book> Books = AddBook.getBookLists(); // get all list of books
	   //show menus
		public void deleteBook() {
			Scanner sc = null;
			int choiseNo = 0;
			sc = new Scanner(System.in);
			String choiseFlag = null;
			System.out.println("\t\t\t\t -----------------------------------------------------------------\t\t");
			System.out.println("\t \t \t \t \t \t  On which Details You want to Delete Book   ");
			System.out.println("\t\t\t\t -----------------------------------------------------------------\t\t");
			// SHOW MENU
			System.out.println("\t\t\t\t\t\t 1. Delete Based On Id ");
			System.out.println("\t\t\t\t\t\t 2. Delete Based On Name ");
			System.out.println("\t\t\t\t\t\t 3. Delete Based On Authores Name ");
			System.out.println("\t\t\t\t\t\t 4. Delete Based On Price ");
			System.out.println("\t\t\t\t\t\t 5. Exit ");
			System.out.println();
			System.out.println("\t\t\t\t\t\t Enter Your Choise  - ");
			choiseNo = sc.nextInt();

			switch (choiseNo) {
			case 1:
				deleteById();
				break;
			case 2:
				deleteByName();
				break;
			case 3:
				deleteByAuthorsName();
				break;
			case 4:
				deleteByPrice();
				break;
			case 5:
				System.out.println("Thank you .......for Utilizing our Service");
				break;
			}// switch
		}// search book
		public void deleteByPrice() {
			
			
		}
		public void deleteByAuthorsName() {
			
			
		}
		public void deleteByName() {
		
	}
		public void deleteById() {
			 Scanner sc=null;
			 String bid=null;
			 sc=new Scanner(System.in);
			 System.out.println("Enter a Book id :- ");
			bid=sc.next();
			//find that book id is there or not
			for(Book bk:Books) {
				if(bk.getBid().equalsIgnoreCase(bid)) {
					System.out.println("Book Found");
				}
				else {
					System.out.println("Book Not Found ");
				}
			}
		}//deleteById
}//class
