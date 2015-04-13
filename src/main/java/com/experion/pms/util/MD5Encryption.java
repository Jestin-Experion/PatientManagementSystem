package com.experion.pms.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encryption {	
	
	public String getMD5(String string){
		return MD5(string);
	}
	
	private String MD5(String string){
		
		 String generatedPassword = null;
	        try {
	            // Create MessageDigest instance for MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //Add password bytes to digest
	            md.update(string.getBytes());
	            //Get the hash's bytes
	            byte[] bytes = md.digest();
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            generatedPassword = sb.toString();
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	        }
	        //System.out.println("Password---------MD5-------"+generatedPassword);
		
		return generatedPassword;
		
	}
}