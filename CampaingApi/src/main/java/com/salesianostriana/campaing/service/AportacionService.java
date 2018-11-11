package com.salesianostriana.campaing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campaing.formbean.AportacionDto;
import com.salesianostriana.campaing.model.Aportacion;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.repository.AportacionRepository;
import com.salesianostriana.campaing.repository.CampanyaRepository;
import com.salesianostriana.campaing.repository.DatosMaestrosRepository;
import com.salesianostriana.campaing.repository.UsuarioRepository;

@Service
public class AportacionService {

	@Autowired
	private AportacionRepository repo;
	
	@Autowired
	private CampanyaRepository cRepo;
	
	@Autowired
	private DatosMaestrosRepository dRepo;
	
	@Autowired
	private UsuarioRepository uRepo;
	
	public Aportacion save(AportacionDto nuevaAportacion, Usuario u) {
		Aportacion a = new Aportacion(nuevaAportacion.getDato(), nuevaAportacion.getCantidad(), u);
		a.addCampanya(cRepo.findById(nuevaAportacion.getIdCampanya()).orElse(null));
		a.addDatosMaestros(dRepo.findById(nuevaAportacion.getIdDatosMaestro()).orElse(null));
		a.addUsuario(uRepo.findById(nuevaAportacion.getIdUsuario()).orElse(null));
		return repo.save(a);
	}
}
