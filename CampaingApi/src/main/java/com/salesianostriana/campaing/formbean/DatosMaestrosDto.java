package com.salesianostriana.campaing.formbean;

import lombok.Data;

@Data
public class DatosMaestrosDto {
	
	private long id;
	private String tipo;
	private long id_campanya;
	
	public DatosMaestrosDto(String tipo, long id_campanya) {
		this.tipo = tipo;
		this.id_campanya = id_campanya;
	}	
	
}
