package com.example.jairdev.Report_Microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoResponse {
    private String idProducto;
    private String nombreProducto;
    private int stock;
    private double precio;
    private String sku;
    private String descripcion;
    private String codigoBarras;
    private CategoriaDTO categoria;
    private EstadoDTO estado;
}


