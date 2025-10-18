package com.example.jairdev.Aggregator_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CombinedInfoResponse {
    private UsuarioResponse usuario;
    private List<ProductoResponse> producto;
}
