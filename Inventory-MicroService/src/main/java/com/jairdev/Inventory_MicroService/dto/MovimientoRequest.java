package com.jairdev.Inventory_MicroService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovimientoRequest {

    @NotNull(message = "El usuario es obligatorio")
    private String idUsuario;

    @NotBlank(message = "El tipo de movimiento es obligatorio")
    @Size(max = 100, message = "El tipo de movimiento no debe superar los 100 caracteres")
    private String tipoMovimiento;

    @NotNull(message = "La fecha de movimiento es obligatoria")
    private LocalDateTime fechaMovimiento;

    @Size(max = 255, message = "Las observaciones no deben superar los 255 caracteres")
    private String observaciones;
}