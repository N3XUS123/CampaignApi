package com.salesianostriana.campaing.formbean;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final String email;
    private final String username;
    private final boolean admin;
    
    public JwtAuthenticationResponse(String token, String email, String username, boolean admin) {
        this.token = token;
        this.email = email;
        this.username = username;
        this.admin = admin;
    }

}
