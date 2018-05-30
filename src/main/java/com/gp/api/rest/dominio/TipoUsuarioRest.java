package com.gp.api.rest.dominio;

import com.gp.api.base.BaseRest;
import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.services.interfaces.domain.TipoUsuarioService;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

    public TipoUsuarioRest(final TipoUsuarioService tipoUsuarioService) {
        setBaseService(tipoUsuarioService);
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @POST
    public void guardar(@Suspended final AsyncResponse asyncResponse, final TipoUsuarioDto tipoUsuario) {
        this.tipoUsuarioService.guardar(tipoUsuario).subscribe(
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
