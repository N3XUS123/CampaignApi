package com.salesianostriana.campaing.exception;

public class UsuarioNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 931409663626348047L;

	public UsuarioNotFoundException(Long id) {
		super("No se pudo encontrar al usuario " + id);
	}
}
