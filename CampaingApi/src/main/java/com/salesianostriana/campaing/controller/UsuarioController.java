package com.salesianostriana.campaing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.campaing.exception.UsuarioNotFoundException;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.repository.UsuarioRepository;
import com.salesianostriana.campaing.response.UserDataResponse;
import com.salesianostriana.campaing.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private UsuarioService uService;
	
	@GetMapping("/usuario/{id}")
	public Usuario one(@PathVariable Long id) {

		return repo.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
	}
	
	@GetMapping("/usuario/getUserData")
	public ResponseEntity<?> getUserData() {
		Usuario u = uService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		boolean admin = uService.checkAdmin(u.getEmail());
		return ResponseEntity.ok(new UserDataResponse(u.getEmail(), u.getNombreUsuario(), admin));
	}
}
