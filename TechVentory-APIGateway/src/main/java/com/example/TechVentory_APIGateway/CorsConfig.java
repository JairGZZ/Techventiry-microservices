package com.example.TechVentory_APIGateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();

        // Permitir TODOS los orígenes
        corsConfig.addAllowedOriginPattern("*");

        // Métodos permitidos
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));

        // Todos los headers
        corsConfig.addAllowedHeader("*");

        // Headers expuestos
        corsConfig.addExposedHeader("*");

        // IMPORTANTE: Con allowedOriginPattern("*") puedes usar allowCredentials
        corsConfig.setAllowCredentials(true);

        corsConfig.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}