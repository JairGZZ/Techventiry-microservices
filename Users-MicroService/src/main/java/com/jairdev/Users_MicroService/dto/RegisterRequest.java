package com.jairdev.Users_MicroService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "El nombre del usuario no puede estar vacío")
    private String nombreUsuario;

    @NotBlank(message = "El apellido del usuario no puede estar vacío")
    private String apellidoUsuario;

    @NotBlank(message = "El DNI no puede estar vacío")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
    private String dniUsuario;

    @NotBlank(message = "El telefono no puede estar vacío")
    @Size(min = 9, max = 9, message = "El telefono debe tener 9 dígitos")
    private String telefonoUsuario;

    @Email(message = "El email no puede estar vacío")
    @NotBlank(message = "El correo no puede estar vacío")
    private String correoUsuario;

    @NotBlank(message = "El username no puede estar vacío")
    private String usernameUsuario;

    private String contraseniaUsuario;

    @NotBlank(message = "El estado no puede estar vacía")
    private String estadoUsuario;

    @NotBlank(message = "El rol no puede estar vacío")
    private String rol;
}