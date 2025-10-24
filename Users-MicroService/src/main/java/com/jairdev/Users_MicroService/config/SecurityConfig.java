//package com.jairdev.Users_MicroService.config;
//
//import com.jairdev.Users_MicroService.security.JWTProvider;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final JWTProvider jwtProvider;
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
//                                .anyRequest().permitAll()
//
//                        //  .requestMatchers("/actuator/**","/api/public/**","/api/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                        //.anyRequest().authenticated()
//                )
//                //.addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
//                .cors(customizer -> customizer.configurationSource(corsConfigurationSource()));
//        return http.build();
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.setAllowedOrigins(Arrays.asList(
//                "http://localhost:4200",   // frontend angular
//                "http://localhost:8080"    // Swagger a traves del Gateway
//        ));
//        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//        corsConfig.setAllowCredentials(true);
//        corsConfig.setMaxAge(3600L);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig);
//        return source;
//    }
//
//}