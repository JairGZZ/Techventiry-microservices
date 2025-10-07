package com.jairdev.Products_MicroService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductoRequest {

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 100, message = "El nombre del producto no debe superar los 100 caracteres")
    private String nombreProducto;

    @NotNull(message = "El stock es obligatorio")
    @Positive(message = "El stock debe ser un número positivo")
    private Integer stock;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser un número positivo")
    private Double precio;

    @NotBlank(message = "El SKU es obligatorio")
    @Size(max = 50, message = "El SKU no debe superar los 50 caracteres")
    private String sku;

    @Size(max = 255, message = "La descripción no debe superar los 255 caracteres")
    private String descripcion;

    @Size(max = 50, message = "El código de barras no debe superar los 50 caracteres")
    private String codigoBarras;

    @NotNull(message = "La categoría es obligatoria")
    private String idCategoria;

    @NotNull(message = "El estado es obligatorio")
    private String idEstado;
}