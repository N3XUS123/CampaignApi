package com.salesianostriana.campaing.exception;

public class CampanyaNotFoundException extends RuntimeException{

	public CampanyaNotFoundException(Long id) {
		super("No se pudo encontrar la campaña " + id);
	}
}
