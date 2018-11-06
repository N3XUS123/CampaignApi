package com.salesianostriana.campaing.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USUARIO")
public class Usuario {

	@Id @GeneratedValue
	private long id;
	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;
	@Column(name="EMAIL")
	private String email;
	@Column(name="CONTRASENYA")
	private String contrasenya;
	@Column(name="GRUPO")
	private String grupo;
	@Column(name = "ENABLED")
    private Boolean enabled;
	
	@OneToMany
	Set<Aportacion> aportaciones = new HashSet<Aportacion>();
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;

	public Usuario() {}

	public Usuario(String nombreUsuario, String email, String contrasenya, String grupo) {
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenya = contrasenya;
		this.grupo = grupo;
		this.enabled = true;
	}
	
	
	
	
}
