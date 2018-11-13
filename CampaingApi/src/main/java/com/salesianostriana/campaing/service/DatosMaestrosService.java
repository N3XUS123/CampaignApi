package com.salesianostriana.campaing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campaing.formbean.DatosMaestrosDto;
import com.salesianostriana.campaing.formbean.EditDatosMaestrosDto;
import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.model.DatosMaestros;
import com.salesianostriana.campaing.repository.DatosMaestrosRepository;

@Service
public class DatosMaestrosService {

	@Autowired
	private DatosMaestrosRepository repo;

	public List<DatosMaestros> findAll() {
		return repo.findAll();
	}

	public Optional<DatosMaestros> findById(long id) {
		return repo.findById(id);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public DatosMaestros save(DatosMaestrosDto newDatosMaestros, Campanya c) {
		DatosMaestros datoMaestro = new DatosMaestros(newDatosMaestros.getTipo(), c);
		return repo.save(datoMaestro);
	}

	public DatosMaestros edit(EditDatosMaestrosDto newDatosMaestros) {
		DatosMaestros datoMaestro = repo.findById(newDatosMaestros.getId()).orElse(null);
		datoMaestro.setTipo(newDatosMaestros.getTipo());
		return repo.save(datoMaestro);
	}

}
