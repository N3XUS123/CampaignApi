package com.salesianostriana.campaing.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.campaing.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombreUsuario(String username);
}
