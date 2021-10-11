package com.neosoft.besics;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class IOSerializationTest {

	public static void main(String[] args) {
		ObjectOutputStream oos=null;
		//create a list having list of trainers objects
		List<Trainer> trainers=new ArrayList();
	  String outFile="Resources/Trainer.db";
	  //create simple date format
	  SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
	  try {
		  oos=new ObjectOutputStream(new FileOutputStream(outFile));
		  //add objets to lists
		  trainers.add(new Trainer("kartik",sdf.parse("01-11-2011"), true, 30, 8000.0f));
		  trainers.add(new Trainer("shubh",sdf.parse("02-12-2012"), true, 35, 9000.0f));
		  trainers.add(new Trainer("maddy",sdf.parse("03-01-2018"), true, 40, 7000.0f));
		  //now use INhance FOR LOOP FOR STORING OBJ
		   for(Trainer tr: trainers) {
			   oos.writeObject(tr);
		   }
		   System.out.println("Serialization is done !!!!");
	  }catch (Exception e) {
		e.printStackTrace();
	}
    finally {
    	try {
    		if(oos!=null) {
    			oos.close();
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
	}

}
