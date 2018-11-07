package com.salesianostriana.campaing.security;

import java.io.Serializable;

import lombok.Data;

// PETICIÓN DE LOGIN
@Data
public class  JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String email;
    private String password;

    public JwtAuthenticationRequest() {}

//    public JwtAuthenticationRequest(String username, String password) {
//        this.setUsername(username);
//        this.setPassword(password);
//    }
//
//    public String getUsername() {
//        return this.username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return this.password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
