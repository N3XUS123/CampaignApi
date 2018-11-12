package com.salesianostriana.campaing.model;

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
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy="campanya", targetEntity=Aportacion.class)
	@JsonIgnore
	private Set<Aportacion> aportaciones;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy="campanya", targetEntity=DatosMaestros.class)
	@JsonIgnore
	private Set<DatosMaestros> datosMaestros;
	
	@ManyToMany(mappedBy = "campanyas")
	@JsonIgnore
	private Set<Usuario> usuario;

	public Campanya() {
		super();
	}

	public Campanya(String nombreCampanya, String codigo) {
		this.nombreCampanya = nombreCampanya;
		this.codigo = codigo;
	}
	
}
