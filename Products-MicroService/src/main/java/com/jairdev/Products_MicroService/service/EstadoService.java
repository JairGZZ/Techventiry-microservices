package com.jairdev.Products_MicroService.service;


import com.jairdev.Products_MicroService.dto.EstadoRequest;
import com.jairdev.Products_MicroService.entities.Estado;
import com.jairdev.Products_MicroService.exception.ResourceNotFoundException;
import com.jairdev.Products_MicroService.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public Estado guardar(EstadoRequest request) {
        Estado estado = new Estado();
        estado.setNombreEstado(request.getNombreEstado());
        estado.setDescripcion(request.getDescripcion());
        return estadoRepository.save(estado);
    }

    public Estado obtenerPorId(String id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", id));
    }

    public List<Estado> listarTodos() {
        return estadoRepository.findAll();
    }

    public Estado actualizar(String id, EstadoRequest request) {
        Estado estado = obtenerPorId(id);
        estado.setNombreEstado(request.getNombreEstado());
        estado.setDescripcion(request.getDescripcion());
        return estadoRepository.save(estado);
    }

    public void eliminar(String id) {
        Estado estado = obtenerPorId(id);
        estadoRepository.delete(estado);
    }
}