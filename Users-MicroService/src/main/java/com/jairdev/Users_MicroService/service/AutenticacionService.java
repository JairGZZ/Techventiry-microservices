package com.jairdev.Users_MicroService.service;


import com.jairdev.Users_MicroService.dto.LoginRequest;
import com.jairdev.Users_MicroService.dto.LoginResponse;
import com.jairdev.Users_MicroService.dto.RegisterRequest;
import com.jairdev.Users_MicroService.dto.UsuarioDTO;
import com.jairdev.Users_MicroService.entities.Rol;
import com.jairdev.Users_MicroService.entities.Usuario;
import com.jairdev.Users_MicroService.exception.BusinessException;
import com.jairdev.Users_MicroService.exception.ResourceNotFoundException;
import com.jairdev.Users_MicroService.repository.RolRepository;
import com.jairdev.Users_MicroService.repository.UsuarioRepository;
import com.jairdev.Users_MicroService.security.JWTProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacionService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTProvider jwtProvider;

    public LoginResponse login(LoginRequest loginRequest) {
        Usuario usuario = usuarioRepository.findByCorreoUsuario(loginRequest.getCorreoUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "correo", loginRequest.getCorreoUsuario()));

        if (!passwordEncoder.matches(loginRequest.getContraseniaUsuario(), usuario.getContraseniaUsuario())) {
            throw new BusinessException("Contraseña incorrecta");
        }

        String token = jwtProvider.generateToken(usuario.getCorreoUsuario(), usuario.getRol().getNombre());

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNombreUsuario(),
                usuario.getApellidoUsuario(),
                usuario.getDniUsuario(),
                usuario.getTelefonoUsuario(),
                usuario.getCorreoUsuario(),
                usuario.getUsernameUsuario(),
                usuario.getEstadoUsuario(),
                usuario.getRol().getNombre()
        );

        return new LoginResponse(token, usuarioDTO);
    }

    public Usuario register(RegisterRequest registerRequest) {
        if(usuarioRepository.findByCorreoUsuario(registerRequest.getCorreoUsuario()).isPresent()){
            throw new BusinessException("El correo electrónico ya está registrado");
        }

        Usuario usuario = createUsuarioFromRequest(registerRequest);
        usuarioRepository.save(usuario);

        return usuario;
    }

    private Usuario createUsuarioFromRequest(RegisterRequest request) {
        Rol rol = rolRepository.findByNombre(request.getRol())
                .orElseThrow(() -> new ResourceNotFoundException("Rol", "nombre", request.getRol()));

        return Usuario.builder()
                .nombreUsuario(request.getNombreUsuario())
                .apellidoUsuario(request.getApellidoUsuario())
                .dniUsuario(request.getDniUsuario())
                .telefonoUsuario(request.getTelefonoUsuario())
                .correoUsuario(request.getCorreoUsuario())
                .usernameUsuario(request.getUsernameUsuario())
                .contraseniaUsuario(passwordEncoder.encode(request.getContraseniaUsuario()))
                .estadoUsuario(request.getEstadoUsuario())
                .rol(rol)
                .build();
    }
}