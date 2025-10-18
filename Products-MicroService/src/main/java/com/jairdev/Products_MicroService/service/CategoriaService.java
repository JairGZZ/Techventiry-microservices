package com.jairdev.Products_MicroService.service;


import com.jairdev.Products_MicroService.dto.CategoriaRequest;
import com.jairdev.Products_MicroService.entities.Categoria;
import com.jairdev.Products_MicroService.exception.ResourceNotFoundException;
import com.jairdev.Products_MicroService.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria guardar(CategoriaRequest request) {
        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(request.getNombreCategoria());
        categoria.setDescripcion(request.getDescripcion());
        return categoriaRepository.save(categoria);
    }

    public Categoria obtenerPorId(String id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría", "id", id));
    }

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria actualizar(String id, CategoriaRequest request) {
        Categoria categoria = obtenerPorId(id);
        categoria.setNombreCategoria(request.getNombreCategoria());
        categoria.setDescripcion(request.getDescripcion());
        return categoriaRepository.save(categoria);
    }

    public void eliminar(String id) {
        Categoria categoria = obtenerPorId(id);
        categoriaRepository.delete(categoria);
    }
}