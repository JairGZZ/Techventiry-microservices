package com.jairdev.Products_MicroService.service;


import com.jairdev.Products_MicroService.dto.ProductoRequest;
import com.jairdev.Products_MicroService.entities.Categoria;
import com.jairdev.Products_MicroService.entities.Estado;
import com.jairdev.Products_MicroService.entities.Producto;
import com.jairdev.Products_MicroService.exception.ResourceNotFoundException;
import com.jairdev.Products_MicroService.repository.CategoriaRepository;
import com.jairdev.Products_MicroService.repository.EstadoRepository;
import com.jairdev.Products_MicroService.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final EstadoRepository estadoRepository;

    public Producto guardar(ProductoRequest request) {
        Categoria categoria = categoriaRepository.findById(request.getIdCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría", "id", request.getIdCategoria()));
        Estado estado = estadoRepository.findById(request.getIdEstado())
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", request.getIdEstado()));

        Producto producto = Producto.builder()
                .nombreProducto(request.getNombreProducto())
                .descripcion(request.getDescripcion())
                .stock(request.getStock())
                .precio(request.getPrecio())
                .sku(request.getSku())
                .codigoBarras(request.getCodigoBarras())
                .categoria(categoria)
                .estado(estado)
                .build();

        return productoRepository.save(producto);
    }

    public Producto obtenerPorId(String id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public List<Producto> buscarPorNombre(String nombreProducto) {
        return productoRepository.findByNombreProductoContainingIgnoreCase(nombreProducto);
    }

    public List<Producto> buscarPorCategoriaNombre(String nombreCategoria) {
        return productoRepository.findByCategoriaNombreCategoriaContainingIgnoreCase(nombreCategoria);
    }

    public List<Producto> buscarPorEstadoNombre(String nombreEstado) {
        return productoRepository.findByEstadoNombreEstadoContainingIgnoreCase(nombreEstado);
    }

    public Producto actualizar(String id, ProductoRequest request) {
        Producto producto = obtenerPorId(id);
        Categoria categoria = categoriaRepository.findById(request.getIdCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría", "id", request.getIdCategoria()));
        Estado estado = estadoRepository.findById(request.getIdEstado())
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", request.getIdEstado()));

        producto.setNombreProducto(request.getNombreProducto());
        producto.setDescripcion(request.getDescripcion());
        producto.setStock(request.getStock());
        producto.setPrecio(request.getPrecio());
        producto.setSku(request.getSku());
        producto.setCodigoBarras(request.getCodigoBarras());
        producto.setCategoria(categoria);
        producto.setEstado(estado);

        return productoRepository.save(producto);
    }

    public void eliminar(String id) {
        Producto producto = obtenerPorId(id);
        productoRepository.delete(producto);
    }
}