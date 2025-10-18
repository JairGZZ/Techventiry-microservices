package com.jairdev.Users_MicroService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RolRequest {

    @NotBlank(message = "El nombre del rol no puede estar vacío")
    private String nombreRol;

    @NotBlank(message = "La descripción del rol no puede estar vacía")
    private String descripcionRol;
}