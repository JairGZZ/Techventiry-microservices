package com.jairdev.Users_MicroService.repository;

import com.jairdev.Users_MicroService.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByCorreoUsuario(String correoUser);
}