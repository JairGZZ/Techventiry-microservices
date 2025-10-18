package com.jairdev.Inventory_MicroService.repository;

import com.jairdev.Inventory_MicroService.entities.MovimientoProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoProdRepository extends JpaRepository<MovimientoProd, String> {
}