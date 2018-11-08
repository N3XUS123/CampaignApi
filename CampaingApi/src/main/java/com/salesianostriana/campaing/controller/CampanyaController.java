package com.salesianostriana.campaing.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.repository.CampanyaRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@ApiOperation(value = "Prueba2", authorizations = { @Authorization(value="token") }, nickname="Prueba")
public class CampanyaController {

	@Autowired
	private CampanyaRepository repository;
	
	@GetMapping("/listarCampanyas")
	@PreAuthorize("hasRole('USER')")
	public List<Campanya> listAll() {
		return repository.findAll();
	}
	
	@PostMapping("/campanya")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> newCampanya(@RequestBody Campanya newCampanya) {
		Campanya c = repository.save(newCampanya);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();

		return ResponseEntity.created(location).body(c);
	}
}
