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
import org.springframework.web.bind.annotation.PutMapping;
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
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/DatosMaestros/Lista")
	public ResponseEntity<?> listarDatosMaestros(){
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(repo.findAll());
	}
	
	//Añadir
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/DatosMaestros/Aniadir")
	public ResponseEntity<?> newDatosMaestros(@RequestBody DatosMaestros newDatosMaestros) {
		DatosMaestros datosMaestros = repo.save(newDatosMaestros);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(datosMaestros.getId())
				.toUri();

		return ResponseEntity.created(location).body(datosMaestros);
	}
	
	//Editar
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/DatosMaestros/Editar")
	public DatosMaestros replaceDatosMaestros(@RequestBody DatosMaestros newDatosMaestros) {

		return repo.findById(newDatosMaestros.getId()).map(datosMaestros -> {
			datosMaestros.setTipo(newDatosMaestros.getTipo());
			datosMaestros.setCampanya(newDatosMaestros.getCampanya());
			return repo.save(datosMaestros);
		}).orElseGet(() -> {
			return repo.save(newDatosMaestros);
		});
	}
	
	//Delete
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/DatosMaestros/Borrar/{id}")
	public void deleteDatosMaestros(@PathVariable Long id) {
		repo.deleteById(id);
	}

	
}
