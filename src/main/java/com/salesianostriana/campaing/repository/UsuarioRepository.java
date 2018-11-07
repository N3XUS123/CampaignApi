package com.salesianostriana.campaing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.campaing.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);

}
