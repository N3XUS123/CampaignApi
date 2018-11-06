package com.salesianostriana.campaing.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario save(Usuario u) {
		
		return repository.save(u);
	}
}
