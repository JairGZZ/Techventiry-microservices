package com.example.jairdev.Report_Microservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CombinedInfoResponse {
    private UsuarioResponse usuario;
    private ProductoResponse producto;
}
