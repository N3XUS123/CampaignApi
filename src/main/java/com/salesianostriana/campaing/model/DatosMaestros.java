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

	@OneToMany
	Set<Aportacion> aportaciones = new HashSet<Aportacion>();
	
	public DatosMaestros() {
	}

	public DatosMaestros(String tipo) {
		this.tipo = tipo;
	}
	
	
}
