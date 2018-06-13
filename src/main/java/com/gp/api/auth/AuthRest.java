package com.gp.api.auth;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gp.dto.response.LoginRequest;
import com.gp.services.interfaces.auth.AuthService;

@Component
@Path(AuthRest.PATH)
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes({MediaType.APPLICATION_JSON})
public class AuthRest {
	/**
	 * Injeccion del logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthRest.class);
	/**
	 * Creacion del path
	 */
	static final String PATH = "auth";
	/**
	 * Injeccion del AuthService
	 */
	private final AuthService authService;
	
	/**
	 * Constructor que inicializa AuthRest con injeccion de dependencias
	 * @param authService
	 */
	public AuthRest(final AuthService authService) {
		LOGGER.info("Injección de dependencias de la clase.");
		this.authService = authService;
	}
	
	
	@POST
	@Path("login")
	public void login(@Suspended final AsyncResponse asyncResponse, @Valid LoginRequest loginRequest ) {
		LOGGER.info("[login] PRE-CALLBACK");
		this.authService.login(loginRequest).subscribe(
				respuesta -> {
					LOGGER.info("[login] BEGIN");
					LOGGER.info("[login] Invocacion del servicio y envio de respuesta");
					asyncResponse.resume(Response.ok(respuesta).build());
					LOGGER.info("[login] END");
				},
				error -> {
					LOGGER.info("[login] THROW = " + error.getMessage());
					asyncResponse.resume(
							
                            Response
                                    .status(500)
                                    .entity(error.getMessage())
                                    .type(MediaType.TEXT_PLAIN)
                                    .build()
                    );
				}
				
		);		
	}
	
	@POST
	@Path("registrar")
	public void registrar(@Suspended final AsyncResponse asyncResponse, @Valid LoginRequest loginRequest ) {
		LOGGER.info("[registrar] PRE-CALLBACK");
		this.authService.login(loginRequest).subscribe(
				respuesta -> {
					LOGGER.info("[registrar] BEGIN");
					LOGGER.info("[registrar] Invocacion del servicio y envio de respuesta");
					asyncResponse.resume(Response.ok(respuesta).build());
					LOGGER.info("[registrar] END");
				},
				error -> {
					LOGGER.info("[registrar] THROW = " + error.getMessage());
					asyncResponse.resume(
                            Response
                                    .status(500)
                                    .entity(error.getMessage())
                                    .type(MediaType.TEXT_PLAIN)
                                    .build()
                    );
				}
				
		);		
	}
	
}
