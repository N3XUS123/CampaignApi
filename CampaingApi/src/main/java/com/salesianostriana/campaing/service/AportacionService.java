package com.salesianostriana.campaing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campaing.formbean.AportacionDto;
import com.salesianostriana.campaing.model.Aportacion;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.repository.AportacionRepository;
import com.salesianostriana.campaing.repository.CampanyaRepository;
import com.salesianostriana.campaing.repository.DatosMaestrosRepository;

@Service
public class AportacionService {

	@Autowired
	private AportacionRepository repo;

	@Autowired
	private CampanyaRepository cRepo;

	@Autowired
	private DatosMaestrosRepository dRepo;

	public Aportacion save(AportacionDto nuevaAportacion, Usuario u) {
		Aportacion a = new Aportacion(nuevaAportacion.getDato(), nuevaAportacion.getCantidad(),
				cRepo.getOne(nuevaAportacion.getIdCampanya()), dRepo.getOne(nuevaAportacion.getIdDatosMaestro()), u);
		return repo.save(a);
	}

	public List<Aportacion> findAll() {
		return repo.findAll();
	}
	
	public List<Aportacion> Ranking(long idCampanya) {
		return repo.rankingTotal(idCampanya);
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
