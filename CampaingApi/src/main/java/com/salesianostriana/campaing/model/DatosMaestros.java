package com.salesianostriana.campaing.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "DATOS_MAESTROS")
public class DatosMaestros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "TIPO", nullable=false)
	private String tipo;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy="datosMaestros")
	@JsonIgnore
	private List<Aportacion> aportaciones;
	
	@JsonIgnore
	@ManyToOne
	private Campanya campanya;

	public DatosMaestros() {
	}

	public DatosMaestros(String tipo, Campanya campanya) {
		this.tipo = tipo;
		this.campanya = campanya;
	}
	
}
