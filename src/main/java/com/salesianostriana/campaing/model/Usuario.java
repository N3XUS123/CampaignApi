package com.salesianostriana.campaing.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USUARIOS")
public class Usuario {

	@Id @GeneratedValue
	private long id;
	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;
	@Column(name="EMAIL")
	private String email;
	@Column(name="CONTRASEÑA")
	private String contrasenya;
	@Column(name="GRUPO")
	private String grupo;
	
	@OneToMany(mappedBy="USUARIO")
	Set<Aportacion> aportaciones = new HashSet<Aportacion>();

	public Usuario() {
		super();
	}

	public Usuario(String nombreUsuario, String email, String contrasenya, String grupo) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenya = contrasenya;
		this.grupo = grupo;
	
	}
	
	
}
