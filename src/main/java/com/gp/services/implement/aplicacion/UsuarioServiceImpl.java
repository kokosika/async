package com.gp.services.implement.aplicacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.repositorios.interfaces.aplicacion.UsuarioRepositorio;
import com.gp.services.implement.base.BaseServiceImpl;
import com.gp.services.interfaces.aplicacion.UsuarioService;
import com.gp.services.validators.aplicacion.interfaces.UsuarioValidacion;

/**
 * Clase que contendra la implementacion del repositorio UsuarioRepositorio
 * Contendra toda la logica necesaria para realizar operaciones complejas del negocio.
 * Valida los datos que son ingresados por parametros.
 * 
 * @author Franco Cortez
 * @version 1.0
 *
 */
@Service
public class UsuarioServiceImpl extends BaseServiceImpl<UsuarioDto> implements UsuarioService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	/**
	 * Injeccion del repositorio UsuarioRepositorio
	 */	
	private final UsuarioRepositorio usuarioRepositorio;
	
	/**
     * Injeccion de las validaciones TipoUsuarioValidacion
     */
    private final UsuarioValidacion usuarioValidacion;

	/**
     * Constructor que inicializa UsuarioServiceImpl con injeccion de dependencias
     * @param usuarioRepositorio tipo repositorio
     * @param usuarioValidacion tipo validacion
     */
	public UsuarioServiceImpl(final UsuarioRepositorio usuarioRepositorio, final UsuarioValidacion usuarioValidacion) {
		super(usuarioRepositorio);
		this.usuarioRepositorio = usuarioRepositorio;
		this.usuarioValidacion = usuarioValidacion;
	}

}
