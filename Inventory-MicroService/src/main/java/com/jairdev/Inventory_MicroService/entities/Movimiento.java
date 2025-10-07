package com.jairdev.Inventory_MicroService.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tbl_movimiento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movimiento {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id_movimiento")
    private String idMovimiento;

    @Column(name = "id_usuario", nullable = false)
    private String idUsuario;

    @Column(name = "tipo_movimiento", nullable = false)
    private String tipoMovimiento;

    @Column(name = "fecha_movimiento", nullable = false)
    private LocalDateTime fechaMovimiento;

    @Column(name = "observaciones", length = 255)
    private String observaciones;
}
