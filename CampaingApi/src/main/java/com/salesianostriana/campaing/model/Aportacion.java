package com.salesianostriana.campaing.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="APORTACION")
public class Aportacion {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="DATO")
	private String dato;
	@Column(name="CANTIDAD")
	private double cantidad;
	@Column(name="FECHA")
	private LocalDateTime fecha;
	
	@ManyToOne(optional=false, targetEntity=Usuario.class)
	@JsonIgnore
	private Usuario usuario;
	
	@ManyToOne(optional=false, targetEntity=Campanya.class)
	@JsonIgnore
	private Campanya campanya;
	
	@ManyToOne(optional=false, targetEntity=DatosMaestros.class)
	@JsonIgnore
	private DatosMaestros datosMaestros;

	public Aportacion() {
		
	}

	public Aportacion(String dato, double cantidad, Usuario usuario, Campanya campanya,
			DatosMaestros datosMaestros) {
		super();
		this.dato = dato;
		this.cantidad = cantidad;
		this.fecha = LocalDateTime.now();
		this.usuario = usuario;
		this.campanya = campanya;
		this.datosMaestros = datosMaestros;
	}
	
	public void addCampanya(Campanya c) {
		this.setCampanya(c);
		c.getAportaciones().add(this);
	}

	public void removeCampanya(Campanya c) {
		this.setCampanya(null);
		c.getAportaciones().remove(this);
	}

	public Aportacion(String dato, double cantidad, Campanya campanya, DatosMaestros datoMaestro, Usuario usuario) {
		this.dato = dato;
		this.cantidad = cantidad;
		this.fecha = LocalDateTime.now();
		this.campanya = campanya;
		this.datosMaestros = datoMaestro;
		this.usuario = usuario;
		
	}
	
}
