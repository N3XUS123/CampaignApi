package com.salesianostriana.campaing.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.salesianostriana.campaing.model.Authorities;
import com.salesianostriana.campaing.model.Usuario;

// CONVIERTE USUARIO DE LA DB EN USUARIO JWT PARA LOGUEAR
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Usuario user) {
        return new JwtUser(
                user.getId(),
                user.getNombreUsuario(),
                user.getEmail(),
                user.getContrasenya(),
                user.getEnabled(),
                mapToGrantedAuthorities(user.getAuthorities())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authorities> list) {
        return list.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
    }
}
