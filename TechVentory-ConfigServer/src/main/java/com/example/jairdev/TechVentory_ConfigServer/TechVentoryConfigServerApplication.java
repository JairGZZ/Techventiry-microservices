package com.example.jairdev.TechVentory_ConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TechVentoryConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechVentoryConfigServerApplication.class, args);
	}

}
