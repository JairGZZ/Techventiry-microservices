package com.jairdev.Products_MicroService.controller;


import com.jairdev.Products_MicroService.dto.CategoriaRequest;
import com.jairdev.Products_MicroService.entities.Categoria;
import com.jairdev.Products_MicroService.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@Valid @RequestBody CategoriaRequest request) {
        Categoria nuevaCategoria = categoriaService.guardar(request);
        return ResponseEntity.status(201).body(nuevaCategoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        List<Categoria> categorias = categoriaService.listarTodos();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable String id) {
        Categoria categoria = categoriaService.obtenerPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(
            @PathVariable String id,
            @Valid @RequestBody CategoriaRequest request
    ) {
        Categoria actualizada = categoriaService.actualizar(id, request);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable String id) {
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}