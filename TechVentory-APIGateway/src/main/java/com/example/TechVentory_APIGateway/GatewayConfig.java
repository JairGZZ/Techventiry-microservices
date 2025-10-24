//package com.example.TechVentory_APIGateway;
//
//
//
//
//import com.example.TechVentory_APIGateway.security.JwtAuthenticationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@RequiredArgsConstructor
//public class GatewayConfig {
//
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                // Rutas públicas (autenticación) - sin filtro JWT
//                .route("auth-service", r -> r
//                        .path("/api/auth/**")
//                        .uri("lb://TECHVENTORY-AUTH-SERVICE"))
//
//                // Rutas protegidas - con filtro JWT
//                // Ejemplo: Servicio de usuarios
//                .route("user-service", r -> r
//                        .path("/api/users/**")
//                        .filters(f -> f.filter(jwtAuthenticationFilter))
//                        .uri("lb://TECHVENTORY-USER-SERVICE"))
//
//                // Ejemplo: Servicio de productos/inventario
//                .route("inventory-service", r -> r
//                        .path("/api/inventory/**")
//                        .filters(f -> f.filter(jwtAuthenticationFilter))
//                        .uri("lb://TECHVENTORY-INVENTORY-SERVICE"))
//
//                // Agrega más rutas según tus microservicios
//                // Reemplaza los nombres de servicio con los que registras en Eureka
//
//                .build();
//    }
//}