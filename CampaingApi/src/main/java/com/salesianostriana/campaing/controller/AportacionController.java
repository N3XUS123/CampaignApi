package com.salesianostriana.campaing.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salesianostriana.campaing.formbean.AportacionDto;
import com.salesianostriana.campaing.model.Aportacion;
import com.salesianostriana.campaing.service.AportacionService;

import io.swagger.annotations.ApiOperation;

public class AportacionController {

	@Autowired
	private AportacionService aService;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/nuevaAportacion")
	@ApiOperation(value="Añadir una nueva aportación")
	public ResponseEntity<?> newAportacion(@RequestBody AportacionDto nuevaAportacion) {
		Aportacion a = aService.save(nuevaAportacion);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getId())
				.toUri();

		return ResponseEntity.created(location).body(a);
	}
}
