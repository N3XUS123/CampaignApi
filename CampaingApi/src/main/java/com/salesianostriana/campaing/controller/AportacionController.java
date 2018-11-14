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

import com.salesianostriana.campaing.formbean.AportacionDto;
import com.salesianostriana.campaing.model.Aportacion;
import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.service.AportacionService;
import com.salesianostriana.campaing.service.CampanyaService;
import com.salesianostriana.campaing.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Aportaciones", description = "REST API DE LAS APORTACIONES DE LOS USUARIOS")
@RequestMapping("/aportaciones/")
public class AportacionController {

	@Autowired
	private AportacionService aService;

	@Autowired
	private UsuarioService uService;

	@Autowired
	private CampanyaService cService;

	@GetMapping("/aportacion/{id}")
	public Aportacion one(@PathVariable Long id) {
		return aService.findOne(id);
	}

	@GetMapping("/list/{id}")
	@ApiOperation(value = "Mostrar listado completo de las aportaciones del usuario en una campaña.")
	public ResponseEntity<?> listarMisAportaciones(@PathVariable Long id) {
		String emailLogueado = SecurityContextHolder.getContext().getAuthentication().getName();

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(aService
				.allMyCampaignsContributions(uService.findByEmail(emailLogueado), cService.findById(id).orElse(null)));
	}

	@PostMapping("/nuevaAportacion")
	@ApiOperation(value = "Añadir una nueva aportación")
	public ResponseEntity<?> newAportacion(@RequestBody AportacionDto nuevaAportacion) {
		String emailLogueado = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario u = uService.findByEmail(emailLogueado);
		Aportacion a = aService.save(nuevaAportacion, u);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getId()).toUri();

		return ResponseEntity.created(location).body(a);
	}

	@GetMapping("/rankingAportaciones/{id}")
	@ApiOperation(value = "Mostrar ranking del top cinco aportaciones")
	public ResponseEntity<?> RankingAportaciones(@PathVariable Long id) {
		System.out.println(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(aService.Ranking(id));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/remove/{id}")
	@ApiOperation(value = "Borrar dato maestro")
	public ResponseEntity<?> deleteDatosMaestros(@PathVariable Long id) {
		String emailLogueado = SecurityContextHolder.getContext().getAuthentication().getName();
		Campanya c = aService.findOne(id).getCampanya();
		aService.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(aService.allMyCampaignsContributions(uService.findByEmail(emailLogueado), c));
	}
}
