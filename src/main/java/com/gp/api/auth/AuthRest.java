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

import org.springframework.stereotype.Component;

import com.gp.dto.response.LoginRequest;
import com.gp.services.interfaces.auth.AuthService;

@Component
@Path(AuthRest.PATH)
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes({MediaType.APPLICATION_JSON})
public class AuthRest {

	static final String PATH = "auth";
	private final AuthService authService;
	public AuthRest(final AuthService authService) {
		this.authService = authService;
	}
	
	@POST
	@Path("login")
	public void login(@Suspended final AsyncResponse asyncResponse, @Valid LoginRequest loginRequest ) {		
		this.authService.login(loginRequest).subscribe(
				respuesta -> {
					asyncResponse.resume(Response.ok(respuesta).build());
				},
				error -> {
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
		this.authService.login(loginRequest).subscribe(
				respuesta -> {
					asyncResponse.resume(Response.ok(respuesta).build());
				},
				error -> {
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
