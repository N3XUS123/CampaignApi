package com.salesianostriana.campaing.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salesianostriana.campaing.formbean.CampanyaDto;
import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.repository.CampanyaRepository;
import com.salesianostriana.campaing.service.CampanyaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@ApiOperation(value = "Prueba2", authorizations = { @Authorization(value="token") }, nickname="Prueba")
public class CampanyaController {

	@Autowired
	private CampanyaRepository repository;
	
	@Autowired
	private CampanyaService service;
	
	//Listar
		@PreAuthorize("hasRole('USER')")
		@GetMapping("/listarCampanyas")
		public ResponseEntity<?> listarCampanyas(){
			return ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(repository.findAll());
		}
	
		//Añadir
		@PreAuthorize("hasRole('ADMIN')")
		@PostMapping("/registroCampanya")
		public ResponseEntity<?> newCampanya(@RequestBody CampanyaDto newCampanya) {
			Campanya c = service.save(newCampanya);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId())
					.toUri();

			return ResponseEntity.created(location).body(c);
		}
	
	@DeleteMapping("/campanya/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteCampanya(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
