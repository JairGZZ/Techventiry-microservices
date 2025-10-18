package com.jairdev.Inventory_MicroService.client;


import com.jairdev.Inventory_MicroService.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-microservice")
public interface ProductoClient {

    @GetMapping("api/productos/{id}")
    ProductDTO obtenerPorId(@PathVariable("id") String id);
}
