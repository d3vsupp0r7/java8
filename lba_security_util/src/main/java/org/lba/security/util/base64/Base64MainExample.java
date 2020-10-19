package org.lba.security.util.base64;

import java.util.Base64;

import org.apache.log4j.Logger;

public class Base64MainExample {

	static final Logger logger = Logger.getLogger(Base64MainExample.class);
	
	public static void main(String[] args) {
		
		String username ="my_user_name";
		String pass = "my_user_pwd";
		String httpAuthenticationHeaderString = username + ":" + pass;
		/**/
		byte [] byteArrayHttpAuthHeaderString = httpAuthenticationHeaderString.getBytes();
		String encodedHeader = Base64.getEncoder().encodeToString(byteArrayHttpAuthHeaderString);
		/**/
		logger.debug("Base64 encoded: " + encodedHeader);
		/* DECODE */
		byte[] byteArrayOfBase64String = Base64.getDecoder().decode(encodedHeader.getBytes());
		String decodedString = new String(byteArrayOfBase64String);
		logger.debug("Base64 decoded: " + decodedString);
		
		/**************/
		/**/
		String encode = Base64MainExample.encodeBase64HttpAuthorizationHeader(username, pass);
		logger.debug("[M] Base64 encoded: " + encode);
		/**/
		String decode = Base64MainExample.decodeBase64HttpAuthorizationHeader(encode);
		logger.debug("[M] Base64 decode: " + decode);
	}
	
	public static String encodeBase64HttpAuthorizationHeader(String username, String pass) {
		
		String encodedHeader = null;
		String httpAuthenticationHeaderString = username + ":" + pass;
		/**/
		byte [] byteArrayHttpAuthHeaderString = httpAuthenticationHeaderString.getBytes();
		encodedHeader = Base64.getEncoder().encodeToString(byteArrayHttpAuthHeaderString);
		/**/
		logger.debug("[encodeBase64HttpAuthorizationHeader] Base64 encoded: " + encodedHeader);
		
		return encodedHeader;
	}
	
	public static String decodeBase64HttpAuthorizationHeader(String encodedBase64) {
		
		String decodedString = null;
		
		byte[] byteArrayOfBase64String = Base64.getDecoder().decode(encodedBase64.getBytes());
		decodedString = new String(byteArrayOfBase64String);
		/**/
		logger.debug("[decodeBase64HttpAuthorizationHeader] Base64 dencoded: " + decodedString);
		
		return decodedString;
		
	}
}
