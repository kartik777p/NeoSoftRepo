package com.neosoft.besics;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;

public class IODeserializationTest {

	public static void main(String[] args) {
		ObjectInputStream ois=null;
	  String outFile="Resources/Trainer.db";
	  //create simple date format
	  SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
	  try {
		  ois=new ObjectInputStream(new FileInputStream(outFile));
		     while(true) {
		    	 Trainer trainer=(Trainer)ois.readObject(); //type cast  to own obj
		    	 //display trainer details
		    	 System.out.println("Trainer Details ");
		    	 System.out.println("--------------------------------------------------------------");
		    	 System.out.println("Trainer Name :- "+trainer.getName()+"\t");
		    	 System.out.println("Trainer Birthdate :- "+sdf.format(trainer.getBirthdate())+"\t");
		    	 System.out.println("Trainer Salary :- "+trainer.getSalary()+"\t");
		    	 System.out.println("Trainer gender :- "+trainer.isGender()+"\n");
		     }
		  
	  }catch (EOFException eof) {
	   System.out.println("Its end of the file.....");
	}
	  catch (Exception e) {
		e.printStackTrace();
	}
    finally {
    	try {
    		if(ois!=null) {
    			ois.close();
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}//catch
    }//finally
	}//main
}//class
