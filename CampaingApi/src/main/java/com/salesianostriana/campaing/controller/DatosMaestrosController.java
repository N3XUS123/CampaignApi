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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salesianostriana.campaing.formbean.DatosMaestrosDto;
import com.salesianostriana.campaing.model.DatosMaestros;
import com.salesianostriana.campaing.service.DatosMaestrosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Datos Maestros", description="REST API DE LAS CATEGORIAS DE APORTACIONES")
@RequestMapping("/datosMaestros/")
public class DatosMaestrosController {
	
	@Autowired
	private DatosMaestrosService datosMaestrosService;
	
	//Listar
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/list")
	@ApiOperation(value="Mostrar listado completo de datos maestros")
	public ResponseEntity<?> listarDatosMaestros(){
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(datosMaestrosService.findAll());
	}
	
	//Añadir
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/add")
	@ApiOperation(value="Añadir dato maestro")
	public ResponseEntity<?> newDatosMaestros(@RequestBody DatosMaestrosDto newDatosMaestros) {
		DatosMaestros datosMaestros = datosMaestrosService.save(newDatosMaestros);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(datosMaestros.getId())
				.toUri();

		return ResponseEntity.created(location).body(datosMaestros);
	}
	
	//Editar
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/edit")
	@ApiOperation(value="Editar dato maestro")
	public ResponseEntity<?> replaceDatosMaestros(@RequestBody DatosMaestrosDto newDatosMaestros) {

		DatosMaestros updated = datosMaestrosService.findById(newDatosMaestros.getId()).map(datosMaestros -> {
			return datosMaestrosService.save(newDatosMaestros);
		}).orElseGet(() -> {
			return datosMaestrosService.save(newDatosMaestros);
		});
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
	}
	
	//Delete
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/remove/{id}")
	@ApiOperation(value="Borrar dato maestro")
	public void deleteDatosMaestros(@PathVariable Long id) {
		datosMaestrosService.deleteById(id);
	}

	
}
