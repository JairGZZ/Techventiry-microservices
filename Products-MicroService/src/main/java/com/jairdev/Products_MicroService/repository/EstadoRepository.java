package com.jairdev.Products_MicroService.repository;

import com.jairdev.Products_MicroService.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, String> {
}