package com.salesianostriana.campaing.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="APORTACIÓN")
public class Aportacion {
	
	@Id @GeneratedValue
	private long id;
	@Column(name="DATO")
	private String dato;
	@Column(name="CANTIDAD")
	private double cantidad;
	@Column(name="FECHA")
	private LocalDateTime fecha;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Campanya campanya;
	
	@ManyToOne
	private DatosMaestros datosMaestros;

	public Aportacion() {
		super();
	}

	public Aportacion(String dato, double cantidad, LocalDateTime fecha, Usuario usuario, Campanya campanya,
			DatosMaestros datosMaestros) {
		super();
		this.dato = dato;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.usuario = usuario;
		this.campanya = campanya;
		this.datosMaestros = datosMaestros;
	}
	
	
}
