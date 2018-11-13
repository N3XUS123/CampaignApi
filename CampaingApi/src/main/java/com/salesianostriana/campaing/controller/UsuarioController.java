package com.salesianostriana.campaing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.campaing.exception.UsuarioNotFoundException;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.repository.UsuarioRepository;

public class UsuarioController {

	@Autowired
	private UsuarioRepository repo;
	
	@GetMapping("/usuario/{id}")
	public Usuario one(@PathVariable Long id) {

		return repo.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
	}
}
