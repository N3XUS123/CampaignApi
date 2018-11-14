package com.salesianostriana.campaing.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salesianostriana.campaing.exception.CampanyaNotFoundException;
import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.repository.CampanyaRepository;
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
	private CampanyaRepository repo;

	@GetMapping("/list")
	@ApiOperation(value = "Mostrar listado completo de campañas")
	public ResponseEntity<?> listarCampanyas() {
		String emailLogueado = SecurityContextHolder.getContext().getAuthentication().getName();
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(campanyaService.findAll(uService.findByEmail(emailLogueado)));
	}
	
	@GetMapping("/list/mine")
	@ApiOperation(value = "Mostrar listado completo de campañas unidas por el usuario")
	public ResponseEntity<?> listarMisCampanyas() {
		String emailLogueado = SecurityContextHolder.getContext().getAuthentication().getName();
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(campanyaService.findAllMine(uService.findByEmail(emailLogueado)));
	}

	// Añadir
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/add")
	@ApiOperation(value = "Añadir una nueva campaña")
	public ResponseEntity<?> newCampanya(@RequestBody Campanya newCampanya) {
		Campanya campanya = campanyaService.save(newCampanya);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(campanya.getId())
				.toUri();

		return ResponseEntity.created(location).body(campanya);
	}

	@DeleteMapping("/remove/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Borrar una campaña")
	public ResponseEntity<?> deleteCampanya(@PathVariable Long id) {
		campanyaService.deleteById(id);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(campanyaService.findAll());
	}

	@PostMapping("/join")
	@ApiOperation(value = "Unirse a una campaña")
	public ResponseEntity<?> joinCampaign(@RequestBody String code) {
		String emailLogueado = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario u = uService.findByEmail(emailLogueado);
		u.joinCampaign(campanyaService.findByCode(code));
		uService.edit(u);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(campanyaService.findAll(u));
	}
	
	@GetMapping("/campanya/{id}")
	@ApiOperation(value="Mostrar una campaña")
	public Campanya one(@PathVariable Long id) {

		return repo.findById(id).orElseThrow(() -> new CampanyaNotFoundException(id));
	}
}
