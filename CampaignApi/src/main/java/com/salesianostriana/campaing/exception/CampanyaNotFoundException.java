package com.salesianostriana.campaing.exception;

public class CampanyaNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6193001856232956667L;

	public CampanyaNotFoundException(Long id) {
		super("No se pudo encontrar la campaña " + id);
	}
}
