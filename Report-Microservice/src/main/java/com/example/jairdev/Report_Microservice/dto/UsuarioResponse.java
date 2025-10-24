package com.example.jairdev.Report_Microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponse {
    private String idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String dniUsuario;
    private String telefonoUsuario;
    private String correoUsuario;
    private String usernameUsuario;
    private String estadoUsuario;
    private RolDTO rol;
}

