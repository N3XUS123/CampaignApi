package com.salesianostriana.campaing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.repository.CampanyaRepository;
import com.salesianostriana.campaing.response.CampanyaResponse;

@Service
public class CampanyaService {
	
	@Autowired
	private CampanyaRepository repository;
	
	public Campanya save(Campanya nuevaCampanya) {
		return repository.save(nuevaCampanya);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

//	public List<CampanyaResponse> findAll() {
//		List<CampanyaResponse> cResponse = new ArrayList<>();
//		for (Campanya i: repository.findAll()) {
//			cResponse.add(i);
//		}
//	}

	public Optional<Campanya> findById(Long id) {
		return repository.findById(id);
	}

	public List<Campanya> findAll() {
		return repository.findAll();
	}
	
	private boolean checkUnido(Campanya c, Usuario u) {
		boolean unido = false;
		if (c.getUsuario().contains(u))
			unido = true;
		return unido;
	}
	
	public List<CampanyaResponse> findAll(Usuario u) {
		List<CampanyaResponse> cResp = new ArrayList<CampanyaResponse>();
		for (Campanya i: repository.findAll()) {
			CampanyaResponse c = new CampanyaResponse(i.getId(), i.getNombreCampanya(), i.getCodigo(), checkUnido(i, u));
			cResp.add(c);
		}
		return cResp;
	}
	
	public Campanya findByCode(String code) {
		return repository.findFirstByCodigo(code);
	}
		
}
