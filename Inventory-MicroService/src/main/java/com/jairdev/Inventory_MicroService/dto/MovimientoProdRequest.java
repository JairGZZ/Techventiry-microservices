package com.jairdev.Inventory_MicroService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovimientoProdRequest {

    @NotNull(message = "La cantidad es obligatoria")
    private Integer cantidad;

    @NotNull(message = "El ID del movimiento es obligatorio")
    private String idMovimiento;

    @NotNull(message = "El ID del producto es obligatorio")
    private String idProducto;
}