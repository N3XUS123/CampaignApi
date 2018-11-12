package com.salesianostriana.campaing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.campaing.model.Aportacion;

public interface AportacionRepository extends JpaRepository<Aportacion, Long> {

	@Query(value = "SELECT * FROM APORTACION WHERE CAMPANYA = ?1 GROUP BY USUARIO ORDER BY CANTIDAD LIMIT 5", nativeQuery = true)
	public List<Aportacion> ranking(long idCampanya);

}