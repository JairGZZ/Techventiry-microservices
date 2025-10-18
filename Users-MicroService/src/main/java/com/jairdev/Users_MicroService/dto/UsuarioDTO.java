package com.jairdev.Users_MicroService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDTO {
    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String correo;
    private String username;
    private String estado;
    private String rol;
}