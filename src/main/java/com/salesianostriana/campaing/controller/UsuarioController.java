package com.salesianostriana.campaing.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salesianostriana.campaing.formbean.RegistroDto;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/registro")
	public ResponseEntity<?> newUsuario(@RequestBody RegistroDto nuevoUsuario) {
		
		Usuario u = usuarioService.save(nuevoUsuario);
		//Usuario u = repository.save(nuevoUsuario);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(u.getId()).toUri();
		
		return ResponseEntity
				.created(location)
				.body(u);
	}
}
