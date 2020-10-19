package org.lba.security.util.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class MD5MainExample {

	static final Logger logger = Logger.getLogger(MD5MainExample.class);
	
	public static void main(String[] args) {
		
		String plaintext = "Hello world";
		/**/
		try {
			String algorithm = "MD5";
			MessageDigest md = MessageDigest.getInstance(algorithm);
			/**/
			byte[] encodedMD5String = md.digest(plaintext.getBytes());
			String decodedString = new String(encodedMD5String);
			logger.debug("MD5 encoded: " + decodedString);
			logger.debug("[B2H] MD5 encoded: " + MD5MainExample.bytesToHex(encodedMD5String) );
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		/**/
		
	}
	
	private static String bytesToHex(byte[] bytes) {
		
		StringBuilder sb = new StringBuilder();
		
		for(byte b : bytes) {
			sb.append(String.format("%02x",b));
		}
		
		return sb.toString();
	}
}
