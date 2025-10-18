package com.jairdev.Users_MicroService.config;


import com.jairdev.Users_MicroService.entities.Rol;
import com.jairdev.Users_MicroService.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final RolRepository rolRepository;

    @Override
    public void run(String... args) throws Exception {
        createRoleIfNotFound("Administrador", "Administrador del sistema");
        createRoleIfNotFound("Usuario", "Usuario estándar del sistema");
    }

    private void createRoleIfNotFound(String nombre, String descripcion) {
        rolRepository.findByNombre(nombre)
                .orElseGet(() -> {
                    Rol rol = new Rol();
                    rol.setNombre(nombre);
                    rol.setDescripcion(descripcion);
                    return rolRepository.save(rol);
                });
    }
}
