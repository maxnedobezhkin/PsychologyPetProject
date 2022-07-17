package com.example.demo.security.jwt;

import io.jsonwebtoken.Claims;


public class JwtUtils {
	
	public JwtUtils() {
	}
	
	public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
//        jwtInfoToken.setRoles(getRoles(claims));
        jwtInfoToken.setFirstName(claims.get("firstName", String.class));
        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }
}
