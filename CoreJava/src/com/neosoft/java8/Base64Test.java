package com.neosoft.java8;

import java.net.URL;
import java.util.Base64;

public class Base64Test {

	public static void main(String[] args) throws Exception {
		
		  String msg = "Welcome to Java 8 features!!";
		  System.out.println("Orignal Msg  : "+msg);
		  //url encoder
		    Base64.Encoder encoder = Base64.getEncoder(); 
		    String encodedMsg =encoder.encodeToString(msg.getBytes());
		    System.out.println("Encoded Msg: " +encodedMsg);
		  
		  //url Decoder
		   Base64.Decoder decoder = Base64.getDecoder(); 
		   String decodedMsg =new String(decoder.decode(encodedMsg)); 
		   System.out.println("Decoded Msg: " +decodedMsg);
		   System.out.println("-------------------------------------------------------------------------------------------------------------------");
		 
		   URL url = new URL("https://www.neosofttech.com/technologies/java");
		System.out.println("Original url: " + url);

		// Encoding
		Base64.Encoder url_encoder = Base64.getUrlEncoder();
	//	String encodedUrl = url_encoder.encodeToString(url.getPath().getBytes());   //only path is get encoded
		String encodedUrl = url_encoder.encodeToString(url.toString().getBytes());    //gives hole url as encoded url 
		System.out.println("Encoded Url: " + encodedUrl);
		
		// Decoding
		Base64.Decoder url_decoder = Base64.getUrlDecoder();
		String decodedUrl = new String(url_decoder.decode(encodedUrl));
		System.out.println("Decoded Url: " + decodedUrl);
		 }

}
