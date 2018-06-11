package com.gp.api.rest.aplicacion;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gp.api.base.BaseRest;
import com.gp.api.rest.dominio.TipoUsuarioRest;
import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.services.interfaces.aplicacion.UsuarioService;
import com.gp.services.interfaces.domain.TipoUsuarioService;

@Component
@Path(UsuarioRest.PATH)
@Produces({MediaType.APPLICATION_JSON})
@SuppressWarnings("all")
public class UsuarioRest extends BaseRest<UsuarioDto> {
	
	static final String PATH = "/usuario";
    private final UsuarioService usuarioService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRest.class);
    
    public UsuarioRest(final UsuarioService usuarioService) {
        super(usuarioService);
        this.usuarioService = usuarioService;
    }
    
    
    

}
