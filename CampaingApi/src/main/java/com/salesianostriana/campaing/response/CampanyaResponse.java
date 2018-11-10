package com.salesianostriana.campaing.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CampanyaResponse {

	private Long id;
	private String nombreCampanya;
	private String codigo;
	private boolean unido;
	
}
