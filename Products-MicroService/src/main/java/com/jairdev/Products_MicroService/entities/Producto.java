package com.jairdev.Products_MicroService.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "tbl_producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id_producto")
    private String idProducto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "stock_producto", nullable = false)
    private Integer stock;

    @Column(name = "precio_producto", nullable = false)
    private Double precio;

    @Column(name = "sku_producto", nullable = false)
    private String sku;

    @Column(name = "descripcion_producto")
    private String descripcion;

    @Column(name = "codigo_barras_producto")
    private String codigoBarras;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
}
