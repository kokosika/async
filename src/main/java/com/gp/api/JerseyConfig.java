package com.gp.api;

import com.gp.api.auth.AuthRest;
import com.gp.api.rest.aplicacion.UsuarioRest;
import com.gp.api.rest.dominio.TipoUsuarioRest;

import javax.ws.rs.ApplicationPath;

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
//@ApplicationPath(value = "api/rest")
public class JerseyConfig extends ResourceConfig {
    /**
     * Constructor que crea una instancia de todos los servicios
     * para su injeccion.
     */
    public JerseyConfig() {
        register(TipoUsuarioRest.class);
        register(UsuarioRest.class);
        register(AuthRest.class);
    }
}
