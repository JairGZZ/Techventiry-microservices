package com.jairdev.Inventory_MicroService.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movements")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movement {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    private String usuarioId;  // viene de Usuarios microservicio

    private String tipoMovimiento;

    private LocalDateTime fechaMovimiento;

    private String observaciones;

    @OneToMany(mappedBy = "movement", cascade = CascadeType.ALL)
    private List<ProductMovement> productos;
}
