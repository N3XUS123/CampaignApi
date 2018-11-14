package com.salesianostriana.campaing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.campaing.model.DatosMaestros;

public interface DatosMaestrosRepository extends JpaRepository<DatosMaestros, Long>{

	@Query(value = "SELECT * FROM DATOSMAESTROS WHERE CAMPANYA = ?1")
	public List<DatosMaestros> listarDatosCampanya(long idCampanya);
}
