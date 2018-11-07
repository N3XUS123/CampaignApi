package com.salesianostriana.campaing.formbean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RegistroDto {
	
	private String username;
	private String email;
	private String password;
	private String grupo;	
	
}
