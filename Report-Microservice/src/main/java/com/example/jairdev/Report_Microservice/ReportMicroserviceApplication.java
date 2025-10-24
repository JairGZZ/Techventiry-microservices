package com.example.jairdev.Report_Microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.jairdev.Report_Microservice.clients")
public class ReportMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportMicroserviceApplication.class, args);
	}
}
