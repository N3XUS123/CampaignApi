package com.salesianostriana.campaing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.campaing.model.Aportacion;
import com.salesianostriana.campaing.model.Campanya;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.response.RankingQueryResponse;

public interface AportacionRepository extends JpaRepository<Aportacion, Long> {

	@Query(value = "SELECT USUARIO AS U, SUM(CANTIDAD) AS C FROM APORTACION WHERE CAMPANYA = ?1 GROUP BY DATO_MAESTRO ORDER BY SUM(CANTIDAD)", nativeQuery = true)
	public List<RankingQueryResponse> rankingTotal(long idCampanya);
	
	@Query(value= "SELECT * FROM APORTACION WHERE USUARIO = ?1 AND CAMPANYA = ?2", nativeQuery = true)
	public List<Aportacion> allMyCampaignsContributions(Usuario u, Campanya c);
	
}