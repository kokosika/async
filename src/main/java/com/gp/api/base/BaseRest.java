package com.gp.api.base;

import com.gp.dto.base.IntegerIdDto;
import com.gp.services.interfaces.base.BaseService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Base de los servicios rest
 * Produce APPLICATION_JSON y TEXT_PLAIN
 * Consume APPLICATION_JSON
 * Genera los metodos genericos para todas los repositorios.
 *
 * @param <T> to pasado pasado por parametros a la clase extiende de {@link IntegerIdDto}
 *
 * @author Franco Cortez
 * @version 1.0
 */
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes({MediaType.APPLICATION_JSON})
public abstract class BaseRest<T extends IntegerIdDto> {

    /**
     * Injeccion de la base de los servicios para realizar metodos genericos
     */	
    private final BaseService<T> baseService;
    
    public BaseRest(final BaseService<T> baseService) {
    	this.baseService = baseService;
    }

    /**
     * Metodo lo Get que genera una respuesta asincrona
     * Obtiene todas los registros de la entidad.
     *
     * @param asyncResponse respuesta asincrono
     */
    @SuppressWarnings("all")
    @GET
    public void buscarTodos(@Suspended final AsyncResponse asyncResponse) {
        this.baseService.buscarTodos().subscribe(
                resultado -> {
                    asyncResponse.resume(Response.ok(resultado).build());
                },
                error -> {
                    asyncResponse.resume(
                            Response
                                    .status(500)
                                    .entity(error)
                                    .type(MediaType.TEXT_PLAIN)
                                    .build()
                    );
                }
        );
    }   
}
