package com.salesianostriana.campaing.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.security.JwtAuthorizationTokenFilter;
import com.salesianostriana.campaing.service.CampanyaService;
import com.salesianostriana.campaing.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Campañas", description = "REST API DE LAS CAMPAÑAS")
@RequestMapping("/campanyas")
public class CampanyaController {

	@Autowired
	private CampanyaService campanyaService;

	@Autowired
	private UsuarioService uService;

	@Autowired
	private JwtAuthorizationTokenFilter tokenFilter;

//	// Listar
//	@PreAuthorize("hasRole('USER')")
//	@GetMapping("/list")
//	@ApiOperation(value = "Mostrar listado completo de campañas")
//	public ResponseEntity<?> listarCampanyas() {
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(campanyaService.findAll());
//	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/list")
	@ApiOperation(value = "Mostrar listado completo de campañas")
	public ResponseEntity<?> listarCampanyas(HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(campanyaService.findAll(uService.findByEmail(tokenFilter.returnUsernameFromToken(request))));
	}

	// Añadir
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/new")
	@ApiOperation(value = "Añadir una nueva campaña")
	public ResponseEntity<?> newCampanya(@RequestBody Campanya newCampanya) {
		Campanya c = campanyaService.save(newCampanya);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();

		return ResponseEntity.created(location).body(c);
	}

	@DeleteMapping("/remove/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Borrar una campaña")
	public ResponseEntity<?> deleteCampanya(@PathVariable Long id) {
		campanyaService.deleteById(id);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(campanyaService.findAll());
	}

	@PreAuthorize("hasRole('USER')")
	@PostMapping("/join")
	@ApiOperation(value = "Unirse a una campaña")
	public ResponseEntity<?> joinCampaign(HttpServletRequest request, String code) {
		Usuario u = uService.findByEmail(tokenFilter.returnUsernameFromToken(request));
		u.joinCampaign(campanyaService.findByCode(code));
		uService.edit(u);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(campanyaService.findAll());
	}
}
