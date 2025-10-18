package com.jairdev.Products_MicroService.repository;

import com.jairdev.Products_MicroService.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String>{
    List<Producto> findByNombreProductoContainingIgnoreCase(String nombreProducto);
    List<Producto> findByCategoriaNombreCategoriaContainingIgnoreCase(String nombreCategoria);
    List<Producto> findByEstadoNombreEstadoContainingIgnoreCase(String nombreEstado);
}