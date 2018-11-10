package com.salesianostriana.campaing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campaing.config.PasswordEncrypt;
import com.salesianostriana.campaing.formbean.RegistroDto;
import com.salesianostriana.campaing.model.Authorities;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario save(RegistroDto nuevoUsuario) {
		Usuario u = new Usuario(nuevoUsuario.getUsername(), nuevoUsuario.getEmail(),
				PasswordEncrypt.encryptPassword(nuevoUsuario.getPassword()), nuevoUsuario.getGrupo());
		u.addRole(new Authorities("ROLE_USER", u));
		return repository.save(u);
	}
	
	public Usuario findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public boolean checkEmailRegistered(String email) {
		boolean verify = false;
		if (findByEmail(email) != null) {
			verify = true;
		}
		return verify;
	}
	
	public boolean checkAdmin(String email) {
		List<Authorities> auths = findByEmail(email).getAuthorities();
		for (Authorities i: auths) {
		    if (i.getAuthority().contains("ROLE_ADMIN"))
				return true;
		}
		
		return false;	
	}
	
}
