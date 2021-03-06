package com.salesianostriana.campaing.model;

import java.util.ArrayList;
import java.util.List;

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
	@Column(name="NOMBRE_CAMPANYA", nullable=false)
	private String nombreCampanya;
	@Column(name="CODIGO", unique=true, nullable=false)
	private String codigo;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval=true, mappedBy="campanya")
	private List<Aportacion> aportaciones;
	
	@JsonIgnore
	@OneToMany(mappedBy="campanya", orphanRemoval=true, cascade=CascadeType.REMOVE)
	private List<DatosMaestros> datosMaestro;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "campanyas")
	private List<Usuario> usuario = new ArrayList<>();

	public Campanya() {
	}

	public Campanya(String nombreCampanya, String codigo) {
		this.nombreCampanya = nombreCampanya;
		this.codigo = codigo;
	}
	
}
