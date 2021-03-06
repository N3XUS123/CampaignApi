package com.salesianostriana.campaing.exception;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

// ENTRYPOINT | Envia error cuando accedes a URL no permitida.

@Component
public class JwtAuthenticationEntryPoint extends BasicAuthenticationEntryPoint
		implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -8970718410437077606L;

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("localhost");
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().println("Alerta! Error 401 " + authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Alerta! Error 401 " + authException.getMessage());

	}
}