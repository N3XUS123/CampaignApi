package com.salesianostriana.campaing.model;

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
@Table(name = "DATOS_MAESTROS")
public class DatosMaestros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "TIPO")
	private String tipo;

	@ManyToOne
	@JsonIgnore
	private Campanya campanya;

	public DatosMaestros() {
	}

	public DatosMaestros(String tipo) {
		this.tipo = tipo;
	}

	public void addCampanya(Campanya c) {
		this.setCampanya(c);
		c.getDatosMaestros().add(this);
	}

	public void removeCampanya(Campanya c) {
		this.setCampanya(null);
		c.getDatosMaestros().remove(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatosMaestros other = (DatosMaestros) obj;
		if (id != other.id)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	
	

}
