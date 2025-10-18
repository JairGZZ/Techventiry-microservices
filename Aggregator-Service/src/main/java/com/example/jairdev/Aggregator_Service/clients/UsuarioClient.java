package com.example.jairdev.Aggregator_Service.clients;

import com.example.jairdev.Aggregator_Service.dto.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-microservice")
public interface UsuarioClient {
    @GetMapping("api/usuarios/{id}")
    UsuarioResponse obtenerUsuarioPorId(@PathVariable("id") String id);
}

