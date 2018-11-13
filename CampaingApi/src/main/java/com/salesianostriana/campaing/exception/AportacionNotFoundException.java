package com.salesianostriana.campaing.exception;

public class AportacionNotFoundException extends RuntimeException{

	public AportacionNotFoundException(Long id) {
		super("No se pudo encontrar la aportación " + id);
	}
}
