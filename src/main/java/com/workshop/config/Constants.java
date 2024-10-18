package com.workshop.config;

import com.auth0.jwt.algorithms.Algorithm;

public class Constants {

	public final static String SECRET = "workshop";
	
	public static Algorithm algorithm(String secret) {
		return Algorithm.HMAC256(secret);
	}
	

}
