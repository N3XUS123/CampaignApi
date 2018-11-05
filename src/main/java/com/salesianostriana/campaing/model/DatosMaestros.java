package com.salesianostriana.campaing.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy="DATOS_MAESTROS")
	Set<DatosMaestros> datosMaestros = new HashSet<DatosMaestros>();

	public DatosMaestros() {
		super();
	}

	public DatosMaestros(String tipo) {
		super();
		this.tipo = tipo;
	}
	
	
}
