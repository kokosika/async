package com.gp.api;

import com.gp.api.rest.dominio.TipoUsuarioRest;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Configuracion de los servicios jersey para su administracion.
 *
 * @see org.glassfish.jersey.server.ResourceConfig
 *
 * @author Franco Cortez
 * @version 1.0
 */
@Configuration
@Component
public class JerseyConfig extends ResourceConfig {
    /**
     * Constructor que crea una instancia de todos los servicios
     * para si injeccion.
     */
    public JerseyConfig() {
        register(TipoUsuarioRest.class);
    }
}
