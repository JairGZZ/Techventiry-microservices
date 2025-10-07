package com.jairdev.Inventory_MicroService.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "tbl_movimiento_prod")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovimientoProd {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id_movimiento_prod")
    private String id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "id_producto", nullable = false)
    private String idProducto;

    @ManyToOne
    @JoinColumn(name = "id_movimiento")
    private Movimiento movimiento;
}
