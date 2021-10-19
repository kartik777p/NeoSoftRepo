package com.neosoft.bookproject;

import java.util.Scanner;

public class BookmgmtConsoleProjectTest {
	
	public void showMenus() {
		  Scanner sc=null;
		  int choiseNo=0;
		  sc=new Scanner(System.in);
		  String choiseFlag=null;
		  do {
		  System.out.println("\t\t\t\t -----------------------------------------------------------------\t\t");
		  System.out.println("\t \t \t \t \t \t   User Menus ");
		  System.out.println("\t\t\t\t -----------------------------------------------------------------\t\t");
	    //SHOW MENU
		   System.out.println("\t\t\t\t\t\t 1. Add Book");
			System.out.println("\t\t\t\t\t\t 2. Search Book");
			System.out.println("\t\t\t\t\t\t 3. Update Book");
			System.out.println("\t\t\t\t\t\t 4. Delete Book");
			System.out.println("\t\t\t\t\t\t 5. See Lists of Books ");
			System.out.println("\t\t\t\t\t\t 6. Exit ");
			System.out.println();
			System.out.println("\t\t\t\t\t\t Enter Your Choise  - ");
			choiseNo=sc.nextInt();
			
				switch (choiseNo) {
				case 1: new AddBook().addBook();
				             break;
				case 2:new SearchBook().searchBook();
				            break;
				case 3: new UpdateBook().updateBook();
				            break;
				case 4:new DeleteBook().deleteBook();
				           break;
				case 5:new ShowAllBooks().showAllBooks();
				         break;
				case 6: System.out.println("Thank you .......for Utilizing our Service");
				        break;
				}//switch
				//show continue option
				System.out.println();
				 System.out.println("\t\t\t\t \t Do you Want to Continue........");
				 System.out.println("\t\t\t\t\t Please Say Yes/No ");
				 choiseFlag=sc.next();
				 if(choiseFlag.equalsIgnoreCase("no")) {
					 System.out.println("\t\t\t\t\t\t Thank you For Takking Our Service "); //print mg if user said no
				 }
			}while(choiseFlag.equalsIgnoreCase("yes"));  //if yes then continue
	}//showMenus
	
	public static void main(String[] args) {
	System.out.println("\t\t\t\t\t\t Welcome to Book Managment System ");
	//create object of the given class
	BookmgmtConsoleProjectTest test=new BookmgmtConsoleProjectTest();
	//show menus to user
	test.showMenus();

	}//main
}//class
