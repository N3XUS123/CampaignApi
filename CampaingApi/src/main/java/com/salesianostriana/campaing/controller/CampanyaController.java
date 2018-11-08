package com.salesianostriana.campaing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.repository.CampanyaRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@ApiOperation(value = "", authorizations = { @Authorization(value="token") })
public class CampanyaController {

	@Autowired
	private CampanyaRepository repository;
	
	@GetMapping("/listarCampanyas")
	@PreAuthorize("authenticated()")
	public List<Campanya> listAll() {
		return repository.findAll();
	}
}
