package com.jairdev.Products_MicroService.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "tbl_estado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id_estado")
    private String idEstado;

    @Column(name = "nombre_estado", nullable = false, length = 100)
    private String nombreEstado;

    @Column(name = "descripcion_estado", length = 255)
    private String descripcion;
}
