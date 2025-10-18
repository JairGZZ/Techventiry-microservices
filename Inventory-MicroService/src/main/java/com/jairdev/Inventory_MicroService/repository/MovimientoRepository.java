package com.jairdev.Inventory_MicroService.repository;

import com.jairdev.Inventory_MicroService.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, String> {
}