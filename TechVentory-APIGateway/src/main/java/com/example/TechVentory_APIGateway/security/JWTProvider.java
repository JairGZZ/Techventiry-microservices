//package com.example.TechVentory_APIGateway.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import jakarta.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.nio.charset.StandardCharsets;
//
//@Component
//public class JWTProvider {
//
//    @Value("${auth.jwt.secret}")
//    private String secret;
//
//    private SecretKey secretKey;
//
//    @PostConstruct
//    public void init(){
//        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//    }
//
//    public boolean validateToken(String token){
//        try {
//            Jwts.parser()
//                    .verifyWith(secretKey)
//                    .build()
//                    .parseSignedClaims(token);
//            return true;
//        } catch (Exception e){
//            return false;
//        }
//    }
//
//    public String getUsernameFromToken(String token) {
//        return getClaims(token).getSubject();
//    }
//
//    public String getRolFromToken(String token) {
//        return getClaims(token).get("rol", String.class);
//    }
//
//    private Claims getClaims(String token){
//        return Jwts.parser()
//                .verifyWith(secretKey)
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//}