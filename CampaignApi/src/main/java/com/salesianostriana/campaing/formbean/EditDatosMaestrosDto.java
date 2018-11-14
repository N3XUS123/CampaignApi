package com.salesianostriana.campaing.formbean;

import lombok.Data;

@Data
public class EditDatosMaestrosDto {

	private long id;
	private String tipo;
	
	public EditDatosMaestrosDto(long id, String tipo) {
		this.tipo = tipo;
		this.id = id;
	}
	
}
