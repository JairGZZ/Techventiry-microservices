package com.example.jairdev.Aggregator_Service.clients;

import com.example.jairdev.Aggregator_Service.dto.ProductoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "products-microservice")
public interface ProductoClient {
    @GetMapping("api/productos")
    List<ProductoResponse> obtenerTodos();
}
