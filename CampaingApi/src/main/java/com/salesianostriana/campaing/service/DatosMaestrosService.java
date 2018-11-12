package com.salesianostriana.campaing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campaing.formbean.DatosMaestrosDto;
import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.model.DatosMaestros;
import com.salesianostriana.campaing.repository.CampanyaRepository;
import com.salesianostriana.campaing.repository.DatosMaestrosRepository;

@Service
public class DatosMaestrosService {

	@Autowired
	private DatosMaestrosRepository repo;

	@Autowired
	private CampanyaRepository crepo;

	public List<DatosMaestros> findAll() {
		return repo.findAll();
	}

	public Optional<DatosMaestros> findById(long id) {
		return repo.findById(id);
	}

	public void deleteById(Long id) {
		Campanya c = repo.getOne(id).getCampanya();
		repo.getOne(id).removeCampanya(c);
		repo.deleteById(id);
	}

	public DatosMaestros save(DatosMaestrosDto newDatosMaestros) {
		DatosMaestros datoMaestro = new DatosMaestros(newDatosMaestros.getTipo());
		datoMaestro.addCampanya(crepo.findById(newDatosMaestros.getId_campanya()).orElse(null));
		return repo.save(datoMaestro);
	}

}
