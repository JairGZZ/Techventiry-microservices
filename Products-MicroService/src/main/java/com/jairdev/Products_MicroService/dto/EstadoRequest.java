package com.jairdev.Products_MicroService.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EstadoRequest {

    @NotBlank(message = "El nombre del estado es obligatorio")
    @Size(max = 100, message = "El nombre del estado no debe superar los 100 caracteres")
    private String nombreEstado;

    @Size(max = 255, message = "La descripción no debe superar los 255 caracteres")
    private String descripcion;
}