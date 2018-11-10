package com.salesianostriana.campaing.formbean;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

// PETICIÓN DE LOGIN
@Data @NoArgsConstructor
public class  JwtLoginDto implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String email;
    private String password;

}
