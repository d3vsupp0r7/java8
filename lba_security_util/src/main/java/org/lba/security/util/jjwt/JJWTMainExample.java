package org.lba.security.util.jjwt;

import java.security.Key;

import org.apache.log4j.Logger;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JJWTMainExample {

	static final Logger logger = Logger.getLogger(JJWTMainExample.class);

	private Key key;

	public static void main(String[] args) {

		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

		String token = Jwts.builder().setSubject("MySubject")
				.claim("pwd","mypwd_256")
				.signWith(key).compact();
		logger.debug("Build JWT token [H256] with custom claim: " + token);
		/**/
		Key key512 = Keys.secretKeyFor(SignatureAlgorithm.HS512);
		String token512 = Jwts.builder().setSubject("MySubject")
				.claim("pwd","mypwd_512")
				.signWith(key512, SignatureAlgorithm.HS512)
				.compact();
		logger.debug("Build JWT token [H512] with custom claim: " + token512);

		/**/
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		logger.debug("[H256] Out claims : " + claims.toString());
		String claimPwd = (String)claims.get("pwd");
		logger.debug("[H256] claim out: " + claimPwd);
		
		/**/
		Claims claims512 = Jwts.parser().setSigningKey(key512).parseClaimsJws(token512).getBody();
		logger.debug("[H512] Out claims : " + claims512.toString());
		String claimPwd512 = (String)claims512.get("pwd");
		logger.debug("[H512] claim out: " + claimPwd512);
	
	}
}
