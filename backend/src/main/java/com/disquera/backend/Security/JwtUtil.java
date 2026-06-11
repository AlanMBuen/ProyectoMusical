package com.disquera.backend.Security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private static final String SECRET_KEY="zxcvbnmzxcvbnmzxcvbnmzxcvbnmzxcvbnm";

    private SecretKey getKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generatedToken(String nombre){  
        return Jwts.builder().setSubject(nombre).setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
        .signWith(getKey()).compact();
    }

    public String extractUsername(String token){
        return Jwts.parserBuilder().setSigningKey(getKey()).build()
        .parseClaimsJws(token).getBody().getSubject();
    }

    public Boolean validateToken(String token, String username){
        return Jwts.parserBuilder().setSigningKey(getKey()).build()
        .parseClaimsJws(token).getBody().getSubject().equals(username);
    }
}