package com.salesianostriana.campaing.security.service;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final String email;
    
    public JwtAuthenticationResponse(String token, String email) {
        this.token = token;
        this.email = email;
    }

}
