package com.salesianostriana.campaing.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class UserDataResponse {

	private String email;
	private String usuario;
	private boolean admin;
	
}
