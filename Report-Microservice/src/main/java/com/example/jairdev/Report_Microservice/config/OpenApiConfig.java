package com.example.jairdev.Report_Microservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        // Servidor para API Gateway (producción/principal)
        Server gatewayServer = new Server();
        gatewayServer.setUrl("http://localhost:8080/report-microservice");
        gatewayServer.setDescription("API Gateway");

        // Servidor directo al microservicio (desarrollo)
        Server devServer = new Server();
        devServer.setUrl("http://localhost:7676");
        devServer.setDescription("Directo al Microservicio (Dev)");

        return new OpenAPI()
                .info(new Info()
                        .title("Product MicroService")
                        .description("Lista de todos los endpoints disponibles en el servicio de Techventory")
                        .version("1.0.0"))
                .servers(List.of(gatewayServer, devServer))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}