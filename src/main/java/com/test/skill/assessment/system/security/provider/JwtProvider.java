package com.test.skill.assessment.system.security.provider;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtProvider {

	@Value("${jwt.serectKey}")
	private String serectKey;
	
	@Value("${jwt.expiration}")
	private long expiration;
	
	public String generateToken(String userName) {
		return createToken(userName);
	}

	private String createToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		Date date = new Date();
		return Jwts.builder()
				.addClaims(claims)
				.setSubject(userName)
				.setIssuedAt(date)
				.setExpiration(new Date(date.getTime() + expiration))
				.claim("key", "string")
				.signWith(SignatureAlgorithm.HS256, serectKey.getBytes())
				.setHeaderParam(Header.TYPE, Header.JWT_TYPE)
				.compact();
	}
	
	
	public Date extractExpiration(String token) {
		Claims claims = extractAllClaims(token);
        return claims != null ? claims.getExpiration() : null; 
    }
	
	public String extractUsername(String token) { 
		Claims claims = extractAllClaims(token);
        return claims != null ? claims.getSubject() : null; 
    }
	
	private Claims extractAllClaims(String token) { 
        return Jwts.parser()
                .setSigningKey(serectKey.getBytes())
                .parseClaimsJws(token)
                .getBody(); 
    }
	
	public String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
	
	
}
