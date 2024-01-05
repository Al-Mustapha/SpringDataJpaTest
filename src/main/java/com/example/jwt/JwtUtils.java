package com.example.jwt;

import com.example.Database.UserDetailsImpl;
import com.example.Entity.ApplicationUser;
import com.example.Entity.ApplicationUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.sql.Date;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtils {
    private String jwtSignKey = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";

    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }

    public java.util.Date extractExpiration(String token){
        return (java.util.Date) extractClaim(token, Claims::getExpiration);
    }

    public boolean hasClaims(String token, String claimName){
        final Claims claims = extractAllClaims(token);
        return claims.get(claimName)!= null;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSignInKey()).parseClaimsJws(token).getBody();
//        return Jwts.parser().setSigningKey(jwtSignKey).parseClaimsJws(token).getBody();
    }

    public String createToken(Map<String, Object> claims, String subject){
       String token = Jwts.builder()
                .setSubject(subject)
                .claim("Authorization", claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
       return token;
    }

    public Boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(String userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails);
    }

//    public String generateToken(ApplicationUserDetails userDetails, Map<String, Object> claims){
//        return createToken(claims, userDetails);
//    }
    public Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date(System.currentTimeMillis()));
    }

    private Key getSignInKey(){
        final byte[] keyBytes = Decoders.BASE64.decode(jwtSignKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
