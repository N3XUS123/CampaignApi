package com.salesianostriana.campaing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DATOS_MAESTROS")
public class DatosMaestros {
	
	@Id @GeneratedValue
	private long id;
	@Column(name="TIPO")
	private String tipo;

	public DatosMaestros() {
	}

	public DatosMaestros(String tipo) {
		this.tipo = tipo;
	}
	
	
}
