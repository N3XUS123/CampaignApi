package com.salesianostriana.campaing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campaing.exception.AportacionNotFoundException;
import com.salesianostriana.campaing.formbean.AportacionDto;
import com.salesianostriana.campaing.model.Aportacion;
import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.repository.AportacionRepository;
import com.salesianostriana.campaing.repository.DatosMaestrosRepository;
import com.salesianostriana.campaing.repository.UsuarioRepository;
import com.salesianostriana.campaing.response.RankingQueryResponse;
import com.salesianostriana.campaing.response.RankingResponse;

@Service
public class AportacionService {

	@Autowired
	private AportacionRepository repo;

	@Autowired
	private DatosMaestrosRepository dRepo;
	
	@Autowired
	private UsuarioRepository uRepo;

	public Aportacion save(AportacionDto nuevaAportacion, Usuario u) {
		Aportacion a = new Aportacion(nuevaAportacion.getDato(), nuevaAportacion.getCantidad(), 
				dRepo.getOne(nuevaAportacion.getIdDatosMaestro()).getCampanya(), dRepo.getOne(nuevaAportacion.getIdDatosMaestro()), u);
		return repo.save(a);
	}

	public List<Aportacion> findAll() {
		return repo.findAll();
	}
	
	public List<RankingResponse> Ranking(long idCampanya) {
		List<RankingResponse> ListRanking = new ArrayList<>();
		for (RankingQueryResponse rqr: repo.rankingTotal(idCampanya)) {
			ListRanking.add(new RankingResponse(uRepo.findById(rqr.getU()).orElse(null).getGrupo(), rqr.getC()));
		}
		return ListRanking;
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	public List<Aportacion> allMyCampaignsContributions(Usuario u, Campanya c) {
		return repo.allMyCampaignsContributions(u, c);
	}
	
	public Aportacion findOne(Long id) {
		return repo.findById(id).orElseThrow(() -> new AportacionNotFoundException(id));
	}
}
