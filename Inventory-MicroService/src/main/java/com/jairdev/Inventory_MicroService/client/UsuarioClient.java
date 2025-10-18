package com.jairdev.Inventory_MicroService.client;


import com.jairdev.Inventory_MicroService.dto.ProductDTO;
import com.jairdev.Inventory_MicroService.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-microservice")
public interface UsuarioClient {

    @GetMapping("api/usuarios/{id}")
    UsuarioDTO obtenerPorId(@PathVariable("id") String idUsuario);
}
