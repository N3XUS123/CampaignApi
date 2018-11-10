package com.salesianostriana.campaing.formbean;

import java.time.LocalDateTime;

import com.salesianostriana.campaing.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class AportacionDto {

	private String dato;
	private double cantidad;
	private LocalDateTime fecha;
	private Usuario usuario;
	
}
