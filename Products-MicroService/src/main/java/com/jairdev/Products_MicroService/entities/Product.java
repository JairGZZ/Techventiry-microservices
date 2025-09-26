package com.jairdev.Products_MicroService.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    private String nombre;

    private Integer stock;

    private Double precio;

    private String sku;

    private String descripcion;

    private String codigoBarras;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoria;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State estado;
}
