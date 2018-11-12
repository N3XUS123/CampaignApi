package com.salesianostriana.campaing.model;

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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "NOMBRE_USUARIO")
	private String nombreUsuario;
	@Column(name = "EMAIL")
	private String email;
	@JsonIgnore
	@Column(name = "CONTRASENYA")
	private String contrasenya;
	@Column(name = "GRUPO")
	private String grupo;
	@JsonIgnore
	@Column(name = "ENABLED")
	private Boolean enabled;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="usuario", orphanRemoval=true)
	private List<Aportacion> aportaciones;

	@JsonIgnore
	@ManyToMany
	private List<Campanya> campanyas;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Authorities> authorities;

	public Usuario() {
	}

	public Usuario(String nombreUsuario, String email, String contrasenya, String grupo) {
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenya = contrasenya;
		this.grupo = grupo;
		this.enabled = true;
	}

	public Usuario addRole(Authorities a) {
		if (a != null) {
			a.setUser(this);
			this.authorities.add(a);
		}
		return this;
	}

	public Usuario removeRole(Authorities a) {
		if (a != null) {
			a.setUser(null);
			this.getAuthorities().remove(a);
		}
		return this;
	}

	public Usuario joinCampaign(Campanya c) {
		if (c != null) {
			c.getUsuario().add(this);
			this.getCampanyas().add(c);
		}
		return this;
	}

	public Usuario exitCampaign(Campanya c) {
		if (c != null) {
			c.getUsuario().remove(this);
			this.getCampanyas().remove(c);
		}
		return this;
	}

}
