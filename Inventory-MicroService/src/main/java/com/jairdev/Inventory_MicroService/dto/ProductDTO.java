package com.jairdev.Inventory_MicroService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class ProductDTO {
        private String idProducto;
        private String nombreProducto;
        private int stock;
        private double precio;
        private String sku;
        private String descripcion;
        private String codigoBarras;

}


