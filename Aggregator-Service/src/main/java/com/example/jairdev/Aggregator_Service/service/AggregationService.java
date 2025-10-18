package com.example.jairdev.Aggregator_Service.service;


import com.example.jairdev.Aggregator_Service.clients.ProductoClient;
import com.example.jairdev.Aggregator_Service.clients.UsuarioClient;
import com.example.jairdev.Aggregator_Service.dto.CombinedInfoResponse;
import com.example.jairdev.Aggregator_Service.dto.ProductoResponse;
import com.example.jairdev.Aggregator_Service.dto.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AggregationService {

    private final UsuarioClient userClient;
    private final ProductoClient productClient;

    public CombinedInfoResponse combineData(String userId, String productId) {
        UsuarioResponse usuario = userClient.obtenerUsuarioPorId(userId);
        List<ProductoResponse> producto = productClient.obtenerTodos();
        return new CombinedInfoResponse(usuario, producto);
    }
}
