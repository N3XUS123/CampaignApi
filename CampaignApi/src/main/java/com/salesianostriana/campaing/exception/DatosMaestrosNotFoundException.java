package com.salesianostriana.campaing.exception;

public class DatosMaestrosNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -4479113225650739165L;

	public DatosMaestrosNotFoundException(Long id) {
		super("No se pudo encontrar la categoría " + id);
	}
}
