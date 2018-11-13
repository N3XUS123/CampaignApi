package com.salesianostriana.campaing.exception;

public class DatosMaestrosNotFoundException extends RuntimeException{

	public DatosMaestrosNotFoundException(Long id) {
		super("No se pudo encontrar la categoría " + id);
	}
}
