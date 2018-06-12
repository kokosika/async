package com.gp.api.rest.dominio;

import com.gp.api.base.BaseRest;
import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.services.interfaces.domain.TipoUsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path(TipoUsuarioRest.PATH)
@Produces({MediaType.APPLICATION_JSON})
@SuppressWarnings("all")
public class TipoUsuarioRest extends BaseRest<TipoUsuarioDto> {

    static final String PATH = "/tipo-usuario";
    private final TipoUsuarioService tipoUsuarioService;
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoUsuarioRest.class);

    public TipoUsuarioRest(final TipoUsuarioService tipoUsuarioService) {
        super(tipoUsuarioService);
        this.tipoUsuarioService = tipoUsuarioService;
    }
    
    @GET
    @Path("{id}")
    public void buscarPorId(@Suspended final AsyncResponse asyncResponse,@PathParam("id") final Integer id) {
    	LOGGER.info("[buscarPorId] = PRE-OBSERVABLE ");
    	this.tipoUsuarioService.buscarPorId(id).subscribe(
                respuesta -> {
                	LOGGER.info("[buscarPorId] = BEGIN ");
                    asyncResponse.resume(Response.ok(respuesta).build());
                    LOGGER.info("[buscarPorId] = FIN ");
                },
                error -> {
                	LOGGER.info("[buscarPorId] = ERROR = " + error.getMessage());
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
    public void guardar(@Suspended final AsyncResponse asyncResponse, final TipoUsuarioDto tipoUsuario) {
    	LOGGER.info("[guardar] = PRE-OBSERVABLE ");
        this.tipoUsuarioService.guardar(tipoUsuario).subscribe(
                respuesta -> {
                	LOGGER.info("[guardar] = BEGGIN ");
                    asyncResponse.resume(Response.ok(respuesta).build());
                    LOGGER.info("[guardar] = END ");
                },
                error -> {
                	LOGGER.info("[guardar] = ERROR = " + error.getMessage());
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
    
    @PUT
    public void editar(@Suspended final AsyncResponse asyncResponse, final TipoUsuarioDto tipoUsuario) {
    	LOGGER.info("[editar] = PRE-OBSERVABLE ");
        this.tipoUsuarioService.editar(tipoUsuario).subscribe(
                respuesta -> {
                	LOGGER.info("[editar] = BEGGIN ");
                    asyncResponse.resume(Response.ok(respuesta).build());
                    LOGGER.info("[editar] = END ");
                },
                error -> {
                	LOGGER.info("[editar] = ERROR = " + error.getMessage());
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
