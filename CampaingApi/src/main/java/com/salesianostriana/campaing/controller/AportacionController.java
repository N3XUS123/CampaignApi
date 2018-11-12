package com.salesianostriana.campaing.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salesianostriana.campaing.formbean.AportacionDto;
import com.salesianostriana.campaing.model.Aportacion;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.security.JwtAuthorizationTokenFilter;
import com.salesianostriana.campaing.service.AportacionService;
import com.salesianostriana.campaing.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Aportaciones", description="REST API DE LAS APORTACIONES DE LOS USUARIOS")
@RequestMapping("/aportaciones/")
public class AportacionController {

	@Autowired
	private AportacionService aService;
	
	@Autowired
	private JwtAuthorizationTokenFilter tokenFilter;
	
	@Autowired
	private UsuarioService uService;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/listaAportaciones")
	@ApiOperation(value="Mostrar listado completo de aportaciones")
	public ResponseEntity<?> listarAportaciones(){
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(aService.findAll());
	}
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/nuevaAportacion")
	@ApiOperation(value="Añadir una nueva aportación")
	public ResponseEntity<?> newAportacion(HttpServletRequest request, @RequestBody AportacionDto nuevaAportacion) {
		System.out.println(nuevaAportacion);
		Usuario u = uService.findByEmail(tokenFilter.returnUsernameFromToken(request));
		Aportacion a = aService.save(nuevaAportacion, u);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getId())
				.toUri();

		return ResponseEntity.created(location).body(a);
	}
}
