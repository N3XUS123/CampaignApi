package com.salesianostriana.campaing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.campaing.model.DatosMaestros;

public interface DatosMaestrosRepository extends JpaRepository<DatosMaestros, Long>{

	@Query(value = "SELECT * FROM DATOS_MAESTROS WHERE CAMPANYA_ID = ?1", nativeQuery = true)
	public List<DatosMaestros> listarDatosCampanya(long idCampanya);
}
