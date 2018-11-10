package com.salesianostriana.campaing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campaing.formbean.AportacionDto;
import com.salesianostriana.campaing.model.Aportacion;
import com.salesianostriana.campaing.repository.AportacionRepository;

@Service
public class AportacionService {

	@Autowired
	private AportacionRepository repo;
	
	public Aportacion save(AportacionDto nuevaAportacion) {
		Aportacion a = new Aportacion(nuevaAportacion.getDato(), nuevaAportacion.getCantidad(), nuevaAportacion.getFecha(), nuevaAportacion.getUsuario());
		return repo.save(a);
	}
}
