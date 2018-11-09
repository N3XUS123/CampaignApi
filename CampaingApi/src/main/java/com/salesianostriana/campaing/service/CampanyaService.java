package com.salesianostriana.campaing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campaing.formbean.CampanyaDto;
import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.repository.CampanyaRepository;

@Service
public class CampanyaService {
	
	@Autowired
	private CampanyaRepository repository;
	
	public Campanya save(CampanyaDto nuevaCampanya) {
		Campanya c = new Campanya(nuevaCampanya.getNombreCampanya(), nuevaCampanya.getCodigo());
		return repository.save(c);
	}
}
