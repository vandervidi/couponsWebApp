package com.oa.couponsWebApp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * This is the class that encrypts a string to MD5.
 * @author Vidran & Ofir
 *
 */
public class MD5 {
	/**
	 * This method recieves a string type and returns 
	 * encrypted MD5 string.
	 * 
	 * @param input		The string that will be encrypted.
	 * @return			Encrypted string.
	 */
	public static String encryptMD5(String input) {
		String md5 = null;
		
        if( input == null) return null;
        
        try {
	        //Create MessageDigest object for MD5
	        MessageDigest digest = MessageDigest.getInstance("MD5");
	         
	        //Update input string in message digest
	        digest.update(input.getBytes(), 0, input.length());
	 
	        //Converts message digest value in base 16 (hex) 
	        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
	}
}
