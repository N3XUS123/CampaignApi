package com.salesianostriana.campaing.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.campaing.config.Exceptions;
import com.salesianostriana.campaing.config.JwtTokenUtil;
import com.salesianostriana.campaing.exception.AuthenticationException;
import com.salesianostriana.campaing.formbean.JwtAuthenticationResponse;
import com.salesianostriana.campaing.formbean.JwtLoginDto;
import com.salesianostriana.campaing.formbean.RegistroDto;
import com.salesianostriana.campaing.model.Usuario;
import com.salesianostriana.campaing.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// Controller de logueo
@RestController
@Api(tags = "Login Registro", description="REST API DE LOGIN Y REGISTRO")
public class AuthenticationRestController {

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	@Qualifier("jwtUserDetailsService")
	private UserDetailsService userDetailsService;
	
	

	// Inicio de sesión
	@RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
	@ApiOperation(value="Iniciar sesión")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtLoginDto authenticationRequest)
			throws AuthenticationException {

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
		
		Usuario u = usuarioService.findByEmail(authenticationRequest.getEmail());
		boolean admin = usuarioService.checkAdmin(authenticationRequest.getEmail());
		
		// Reload password post-security so we can generate the token
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);

		// Return the token
		return ResponseEntity.ok(new JwtAuthenticationResponse(token, u.getEmail(), u.getNombreUsuario(), admin));
	}
	
    @PostMapping("/registro")
    @ApiOperation(value="Registrar nuevo usuario")
    public ResponseEntity<?> createRegistrationToken(@RequestBody RegistroDto nuevoUsuario) throws AuthenticationException, Exceptions {

    	if (usuarioService.checkEmailRegistered(nuevoUsuario.getEmail())) {
    		throw new Exceptions("Email Exists");
    	}
    	// Create de User
    	usuarioService.save(nuevoUsuario);
    	
    	Usuario u = usuarioService.findByEmail(nuevoUsuario.getEmail());
		boolean admin = usuarioService.checkAdmin(nuevoUsuario.getEmail());
    	
        // Reload password post-security so we can generate the token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(nuevoUsuario.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token, u.getEmail(), u.getNombreUsuario(), admin));
    }

//    // Refrescar usuario
//    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
//    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
//        String authToken = request.getHeader(tokenHeader);
//        final String token = authToken.substring(7);
//        
//        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
//            String refreshedToken = jwtTokenUtil.refreshToken(token);
//            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
//        } else {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

	// Error de autenticacion
	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}

	// Autentica el usuario. Si algo va mal, lanza una excepción
	private void authenticate(String email, String password) {
		Objects.requireNonNull(email);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new AuthenticationException("User is disabled!", e);
		} catch (BadCredentialsException e) {
			throw new AuthenticationException("Bad credentials!", e);
		}
	}
}
