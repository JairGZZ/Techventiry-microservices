package com.jairdev.Inventory_MicroService.service;

import com.jairdev.Inventory_MicroService.client.UsuarioClient;
import com.jairdev.Inventory_MicroService.dto.MovimientoRequest;
import com.jairdev.Inventory_MicroService.dto.UsuarioDTO;
import com.jairdev.Inventory_MicroService.entities.Movimiento;
import com.jairdev.Inventory_MicroService.exception.ResourceNotFoundException;
import com.jairdev.Inventory_MicroService.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final UsuarioClient usuarioClient; // 👈 inyectamos el FeignClient

    public Movimiento guardar(MovimientoRequest request) {
        // Verificar que el usuario exista (consulta remota)
        UsuarioDTO usuario = usuarioClient.obtenerPorId(request.getIdUsuario());
        if (usuario == null) {
            throw new ResourceNotFoundException("Usuario", "id", request.getIdUsuario());
        }

        Movimiento movimiento = Movimiento.builder()
                .idUsuario(request.getIdUsuario())
                .tipoMovimiento(request.getTipoMovimiento())
                .fechaMovimiento(request.getFechaMovimiento())
                .observaciones(request.getObservaciones())
                .build();

        return movimientoRepository.save(movimiento);
    }

    public Movimiento obtenerPorId(String id) {
        return movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento", "id", id));
    }

    public List<Movimiento> listarTodos() {
        return movimientoRepository.findAll();
    }

    public Movimiento actualizar(String id, MovimientoRequest request) {
        Movimiento movimiento = obtenerPorId(id);

        UsuarioDTO usuario = usuarioClient.obtenerPorId(request.getIdUsuario());
        if (usuario == null) {
            throw new ResourceNotFoundException("Usuario", "id", request.getIdUsuario());
        }

        movimiento.setTipoMovimiento(request.getTipoMovimiento());
        movimiento.setFechaMovimiento(request.getFechaMovimiento());
        movimiento.setObservaciones(request.getObservaciones());
        movimiento.setIdUsuario(request.getIdUsuario());

        return movimientoRepository.save(movimiento);
    }


    public void eliminar(String id) {
        Movimiento movimiento = obtenerPorId(id);
        movimientoRepository.delete(movimiento);
    }
}
