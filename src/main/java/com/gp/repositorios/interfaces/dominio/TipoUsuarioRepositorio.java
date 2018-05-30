package com.gp.repositorios.interfaces.dominio;

import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.repositorios.interfaces.base.BaseCrudRepositorio;

/**
 * Clase de implementacion de la interfaz TipoUsuarioRepositorio
 * Ayudara a la extencion para ayudar a la injeccion de dependencias.
 * @see TipoUsuarioRepositorio
 * Hereda de la interfaz base BaseCrudRepositorio
 * @see BaseCrudRepositorio
 *
 * @author Franco Cortez
 * @version 1.0
 */
public interface TipoUsuarioRepositorio extends BaseCrudRepositorio<TipoUsuarioDto> {
    public TipoUsuarioDto guardar(TipoUsuarioDto tipoUsuario);
}
