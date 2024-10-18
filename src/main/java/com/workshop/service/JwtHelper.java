package com.workshop.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.workshop.config.Constants;
import com.workshop.entity.WorkShopUser;


@Service
public class JwtHelper {


	
	private String secret=Constants.SECRET;
	
	public String getSecret() {
		return secret;
	}
	
	public JwtHelper() {
		
	}

	public void checkToken(String token) {
		JWT.require(Constants.algorithm(secret)).build().verify(token);
	}
	

	
	public String createToken(WorkShopUser user) {
		return  JWT.create()
				.withSubject(user.getEmail())
				.withClaim("id", user.getId())
				.withClaim("role", user.getRole())
				.withExpiresAt(new Date(System.currentTimeMillis()+60*60*60*1000))
				.sign(Constants.algorithm(secret));
	}
	
	  public WorkShopUser decryptToken(String token){
		  try {
			  DecodedJWT decodedJwt= JWT.require(Constants.algorithm(secret)).build().verify(token);
				WorkShopUser user = new WorkShopUser();
				user.setEmail((String)decodedJwt.getSubject());
				user.setRole(decodedJwt.getClaim("role").asString());
				return user;
		} catch (Exception e) {
			System.out.println("error while verifying the token =>"+e.getMessage());
			return null;
		}
		
	}
}
