package com.salesianostriana.campaing.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	@Column(name="CODIGO")
	private String codigo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Aportacion> aportaciones = new HashSet<Aportacion>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JsonIgnore
	private Set<DatosMaestros> datosMaestros = new HashSet<DatosMaestros>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Usuario> usuario = new HashSet<Usuario>();

	public Campanya() {
		super();
	}

	public Campanya(String nombreCampanya, String codigo) {
		this.nombreCampanya = nombreCampanya;
		this.codigo = codigo;
	}
	
	public void addAportacion(Aportacion a) {
		if (a != null) {
			a.setCampanya(this);
			this.getAportaciones().add(a);
		}
	}
	
	public void removeAportacion(Aportacion a) {
		if (a != null) {
			a.setCampanya(null);
			this.getAportaciones().remove(a);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campanya other = (Campanya) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	
}
