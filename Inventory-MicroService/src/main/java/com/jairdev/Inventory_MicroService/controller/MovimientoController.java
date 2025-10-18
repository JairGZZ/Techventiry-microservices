package com.jairdev.Inventory_MicroService.controller;


import com.jairdev.Inventory_MicroService.dto.MovimientoRequest;
import com.jairdev.Inventory_MicroService.entities.Movimiento;
import com.jairdev.Inventory_MicroService.service.MovimientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<Movimiento> crearMovimiento(@Valid @RequestBody MovimientoRequest request) {
        Movimiento nuevoMovimiento = movimientoService.guardar(request);
        return ResponseEntity.status(201).body(nuevoMovimiento);
    }

    @GetMapping
    public ResponseEntity<List<Movimiento>> listarMovimientos() {
        List<Movimiento> movimientos = movimientoService.listarTodos();
        return ResponseEntity.ok(movimientos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> obtenerMovimiento(@PathVariable String id) {
        Movimiento movimiento = movimientoService.obtenerPorId(id);
        return ResponseEntity.ok(movimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> actualizarMovimiento(
            @PathVariable String id,
            @Valid @RequestBody MovimientoRequest request
    ) {
        Movimiento movimientoActualizado = movimientoService.actualizar(id, request);
        return ResponseEntity.ok(movimientoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable String id) {
        movimientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}