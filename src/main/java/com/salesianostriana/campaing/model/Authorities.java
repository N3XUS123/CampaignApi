package com.salesianostriana.campaing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity @Data
@Table(name = "AUTHORITIES")
public class Authorities {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "AUTHORITY")
	private String authority;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Usuario user;

	
	public Authorities() { }
	
	
	public Authorities(String authority, Usuario user) {
		this.authority = authority;
		this.user = user;
	}
	
}