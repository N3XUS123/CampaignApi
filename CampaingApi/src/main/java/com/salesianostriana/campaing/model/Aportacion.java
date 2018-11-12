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
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "USUARIO")
	private Usuario usuario;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CAMPANYA")
	private Campanya campanya;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "DATO_MAESTRO")
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aportacion other = (Aportacion) obj;
		if (Double.doubleToLongBits(cantidad) != Double.doubleToLongBits(other.cantidad))
			return false;
		if (dato == null) {
			if (other.dato != null)
				return false;
		} else if (!dato.equals(other.dato))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cantidad);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dato == null) ? 0 : dato.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	
	
}
