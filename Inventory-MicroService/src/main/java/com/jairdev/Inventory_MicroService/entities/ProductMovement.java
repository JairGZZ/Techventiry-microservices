package com.jairdev.Inventory_MicroService.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "products_movement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductMovement {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    private Integer cantidad;

    private String productoId; // viene de Productos microservicio

    @ManyToOne
    @JoinColumn(name = "movement_id")
    private Movement movement;
}
