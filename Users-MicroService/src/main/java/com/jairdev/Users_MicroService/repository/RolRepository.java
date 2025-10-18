package com.jairdev.Users_MicroService.repository;

import com.jairdev.Users_MicroService.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, String> {
    Optional<Rol> findByNombre(String nombre);
}