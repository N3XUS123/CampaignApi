package com.salesianostriana.campaing.security.controller;

public class AuthenticationException extends RuntimeException {
 
	private static final long serialVersionUID = 2214194451239559963L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
