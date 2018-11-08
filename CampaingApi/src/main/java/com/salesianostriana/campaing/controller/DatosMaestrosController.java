package com.salesianostriana.campaing.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salesianostriana.campaing.model.DatosMaestros;
import com.salesianostriana.campaing.repository.DatosMaestrosRepository;

@RestController
public class DatosMaestrosController {
	
	@Autowired
	private DatosMaestrosRepository repo;
	
	//Listar
	@GetMapping("/DatosMaestros")
	public ResponseEntity<?> listarDatosMaestros(){
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(repo.findAll());
	}
	
	//Añadir
	@PostMapping("/DatosMaestros")
	public ResponseEntity<?> newDatosMaestros(@RequestBody DatosMaestros newDatosMaestros) {
		DatosMaestros datosMaestros = repo.save(newDatosMaestros);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(datosMaestros.getId())
				.toUri();

		return ResponseEntity.created(location).body(datosMaestros);
	}
	
}
