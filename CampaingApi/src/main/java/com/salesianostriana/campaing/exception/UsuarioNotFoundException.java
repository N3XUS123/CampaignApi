package com.salesianostriana.campaing.exception;

public class UsuarioNotFoundException extends RuntimeException{

	public UsuarioNotFoundException(Long id) {
		super("No se pudo encontrar al usuario " + id);
	}
}
