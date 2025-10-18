package com.jairdev.Products_MicroService.repository;

import com.jairdev.Products_MicroService.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}