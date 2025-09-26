package com.jairdev.Users_MicroService.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    private String nombre;

    private String apellido;

    @Column(unique = true, length = 8, nullable = false)
    private String dni;

    private String telefono;

    @Column(unique = true, nullable = false)
    private String correo;

    @Column(unique = true, nullable = false)
    private String username;

    private String contrasenia;

    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private Rol rol;
}
