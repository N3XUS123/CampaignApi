package com.salesianostriana.campaing.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="CAMPANYA")
public class Campanya {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="NOMBRE_CAMPANYA")
	private String nombreCampanya;
	@Column(name="UNIDO")
	private boolean unido;
	
	@OneToMany
	@JsonIgnore
	private Set<Aportacion> aportaciones = new HashSet<Aportacion>();
	
	@OneToMany
	@JsonIgnore
	private Set<DatosMaestros> datosMaestros = new HashSet<DatosMaestros>();

	public Campanya() {
		super();
	}

	public Campanya(String nombreCampanya, boolean unido) {
		super();
		this.nombreCampanya = nombreCampanya;
		this.unido = unido;
	}
	
	
}
