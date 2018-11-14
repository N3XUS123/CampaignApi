package com.salesianostriana.campaing.exception;

public class AportacionNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 885974646452436260L;

	public AportacionNotFoundException(Long id) {
		super("No se pudo encontrar la aportación " + id);
	}
}
