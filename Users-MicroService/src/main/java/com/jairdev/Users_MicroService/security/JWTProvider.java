//package com.jairdev.Users_MicroService.security;
//
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//@RefreshScope
//@Component
//public class JWTProvider {
//
//    @Value("${auth.jwt.secret}")
//    private String secret;
//
//    @Value("${auth.jwt.expiration}")
//    private Long expiration;
//
//    private SecretKey secretKey;
//
//    private void Imprimir(){
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA"+secret);
//    }
//
//    @PostConstruct
//    public void init(){
//        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//        this.Imprimir();
//    }
//
//    public String generateToken(String email, String rol){
//        return Jwts.builder()
//                .subject(email)
//                .claim("rol", rol)
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(secretKey, Jwts.SIG.HS256)
//                .compact();
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