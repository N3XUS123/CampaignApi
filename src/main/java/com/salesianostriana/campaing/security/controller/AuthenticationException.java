package com.salesianostriana.campaing.security.controller;

// ENVIA ERRORES EN EL LOGUEO
public class AuthenticationException extends RuntimeException {
 
	private static final long serialVersionUID = 2214194451239559963L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
