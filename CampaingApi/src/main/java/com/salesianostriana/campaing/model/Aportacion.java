package com.salesianostriana.campaing.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name="APORTACION")
public class Aportacion {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="DATO", nullable=false)
	private String dato;
	@Column(name="CANTIDAD", nullable=false)
	private double cantidad;
	@Column(name="FECHA", nullable=false)
	private LocalDateTime fecha;
	
//	@JsonIgnoreProperties(value="[id, nombreUsuario, email]")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "grupo")
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne
	@JoinColumn(name = "USUARIO", nullable=false)
	private Usuario usuario;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CAMPANYA", nullable=false)
	private Campanya campanya;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "DATO_MAESTRO", nullable=false)
	private DatosMaestros datosMaestros;

	public Aportacion() {}
	
	public Aportacion(String dato, double cantidad, Usuario usuario, Campanya campanya,
			DatosMaestros datosMaestros) {
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
