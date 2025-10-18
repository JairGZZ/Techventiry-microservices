package com.jairdev.Inventory_MicroService.service;

import com.jairdev.Inventory_MicroService.client.ProductoClient;
import com.jairdev.Inventory_MicroService.dto.MovimientoProdRequest;
import com.jairdev.Inventory_MicroService.dto.ProductDTO;
import com.jairdev.Inventory_MicroService.entities.Movimiento;
import com.jairdev.Inventory_MicroService.entities.MovimientoProd;
import com.jairdev.Inventory_MicroService.exception.ResourceNotFoundException;
import com.jairdev.Inventory_MicroService.repository.MovimientoProdRepository;
import com.jairdev.Inventory_MicroService.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimientoProdService {

    private final MovimientoProdRepository movimientoProdRepository;
    private final MovimientoRepository movimientoRepository;
    private final ProductoClient productoClient; // ✅ FeignClient

    public MovimientoProd guardar(MovimientoProdRequest request) {
        Movimiento movimiento = movimientoRepository.findById(request.getIdMovimiento())
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento", "id", request.getIdMovimiento()));

        // ✅ Llamada al microservicio de productos
        ProductDTO producto = productoClient.obtenerPorId(request.getIdProducto());
        if (producto == null) {
            throw new ResourceNotFoundException("Producto", "id", request.getIdProducto());
        }

        MovimientoProd movimientoProd = MovimientoProd.builder()
                .cantidad(request.getCantidad())
                .movimiento(movimiento)
                .idProducto(request.getIdProducto())
                .build();

        return movimientoProdRepository.save(movimientoProd);
    }

    public List<MovimientoProd> guardarTodos(List<MovimientoProdRequest> listaMovimientoProd) {
        return listaMovimientoProd.stream()
                .map(this::guardar)
                .toList();
    }

    public MovimientoProd obtenerPorId(String id) {
        return movimientoProdRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MovimientoProd", "id", id));
    }

    public List<MovimientoProd> listarTodos() {
        return movimientoProdRepository.findAll();
    }

    public MovimientoProd actualizar(String id, MovimientoProdRequest request) {
        MovimientoProd movimientoProd = obtenerPorId(id);

        Movimiento movimiento = movimientoRepository.findById(request.getIdMovimiento())
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento", "id", request.getIdMovimiento()));

        ProductDTO producto = productoClient.obtenerPorId(request.getIdProducto());
        if (producto == null) {
            throw new ResourceNotFoundException("Producto", "id", request.getIdProducto());
        }

        movimientoProd.setCantidad(request.getCantidad());
        movimientoProd.setMovimiento(movimiento);
        movimientoProd.setIdProducto(request.getIdProducto());

        return movimientoProdRepository.save(movimientoProd);
    }

    public void eliminar(String id) {
        MovimientoProd movimientoProd = obtenerPorId(id);
        movimientoProdRepository.delete(movimientoProd);
    }
}
