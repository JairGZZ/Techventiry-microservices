package com.example.jairdev.Report_Microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RolDTO {
    private String id;
    private String nombre;
    private String descripcion;
}