//package com.example.TechVentory_APIGateway.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//@RequiredArgsConstructor
//public class JwtAuthenticationFilter implements GatewayFilter {
//
//    private final JWTProvider jwtProvider;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//
//        String authHeader = request.getHeaders().getFirst("Authorization");
//
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            return onError(exchange, "Missing or invalid Authorization header", HttpStatus.UNAUTHORIZED);
//        }
//
//        String token = authHeader.substring(7);
//
//        try {
//            if (!jwtProvider.validateToken(token)) {
//                return onError(exchange, "Invalid token", HttpStatus.UNAUTHORIZED);
//            }
//
//            String username = jwtProvider.getUsernameFromToken(token);
//            String role = jwtProvider.getRolFromToken(token);
//
//            // Agregar headers para que los microservicios puedan usar esta información
//            ServerHttpRequest modifiedRequest = request.mutate()
//                    .header("X-User-Email", username)
//                    .header("X-User-Role", role)
//                    .build();
//
//            return chain.filter(exchange.mutate().request(modifiedRequest).build());
//
//        } catch (Exception e) {
//            return onError(exchange, "Token validation failed: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
//        }
//    }
//
//    private Mono<Void> onError(ServerWebExchange exchange, String message, HttpStatus status) {
//        ServerHttpResponse response = exchange.getResponse();
//        response.setStatusCode(status);
//        return response.setComplete();
//    }
//}