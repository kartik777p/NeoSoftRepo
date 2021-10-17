package com.neosoft.bookproject;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateBook {
	ArrayList<Book> Books = AddBook.getBookLists(); // get all list of books

	public void updateBook() {
		Scanner sc = null;
		int choiseNo = 0;
		sc = new Scanner(System.in);

		System.out.println();
		System.out.println("\t\t\t\t Which Of the Following  Details you Want to Update ");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("1. Name  ");
		System.out.println("2. Price  ");
		System.out.println("3. Exit");
		System.out.println();
		// get user choise and show option for their choise
		System.out.println("Enter Your Choise Number");
		choiseNo = sc.nextInt();
		switch (choiseNo) {
		case 1:
			updateName();
			break;
		case 2:
			updatePrice();
			break;
		case 3:
			System.out.println("Thank you .........................");
		}// switch
	}// updateBook
	 /****************************************************************************************************************************************/
	// updateName
	public void updateName() {
		Scanner sc = null;
		String bkName, newbkName = null;
		sc = new Scanner(System.in);
		System.out.println("Enter a Book Name for whos Name you want to Update ");
		bkName = sc.next();
		System.out.println("Enter a New Book Name for " + bkName + " Book ");
		newbkName = sc.next();
		// update
		if (Books != null) {
			for (Book bks : Books) {
				if (bks.getBookNam().equalsIgnoreCase(bkName)) {
					bks.setBookNam(newbkName);
					System.out.println("\t\t\t --------------------------------------------------------");
					System.out.println("\t\t\t Book Name Updated Suceesfullly!!!!!!!!!!!");
					System.out.println("\t\t\t ---------------------------------------------------------");
				} // if
				else {
					 try {
	         			 throw new BookNotFoundException("book not Found to Update By Name ");
	         		 }catch (BookNotFoundException bnf) {
						bnf.printStackTrace();
					}//catch
				} // else
			} // for
		} // if
		else {
			System.out.println("There is No Books Record please 1st add books then Do Update operation ");
		} // else
	}// updateName
	 /****************************************************************************************************************************************/
	// updatePrice
	public void updatePrice() {
		Scanner sc = null;
		String bkName = null;
		float newPrice = 0.0f;
		sc = new Scanner(System.in);
		System.out.println("Enter a Book Name for whos Name you want to Update ");
		bkName = sc.next();
		System.out.println("Enter a New Price for the " + bkName + " Given book ");
		newPrice = sc.nextFloat();
		// update
		for (Book bks : Books) {
			if (bks.getBookNam().equalsIgnoreCase(bkName)) {
				bks.setBookPrice(newPrice);
				System.out.println("\t\t\t --------------------------------------------------------");
				System.out.println("\t\t\t Book Price  Updated Suceesfullly!!!!!!!!!!!");
				System.out.println("\t\t\t ---------------------------------------------------------");
			} // if
			else {
				 try {
         			 throw new BookNotFoundException("book not Found to Update By Price");
         		 }catch (BookNotFoundException bnf) {
					bnf.printStackTrace();
				}//catch
			}//else
		} // for
	}// updatePrice
}// class
