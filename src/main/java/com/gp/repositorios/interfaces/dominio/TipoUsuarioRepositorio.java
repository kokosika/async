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
	/**
	 * Guarda uno tipo de usuario en la base de datos
	 * 
	 * @param tipoUsuario objeto de tipo de usuario que se desea persistir
	 * @return retorna el objecto.
	 * @throws Exception
	 */
    public TipoUsuarioDto guardar(TipoUsuarioDto tipoUsuario) throws Exception;
    
    /**
     * Buscar en la base de datos un tipo de usuario a travez de su id
     * 
     * @param id del registro
     * @return el registro como tipo de usuario
     * @throws Exception
     */
    public TipoUsuarioDto buscarPorId(Integer id) throws Exception;
    
    /**
     * Edita un registro dentro de la base de datos.
     * @param tipoUsuarioDto
     * @return
     * @throws Exception
     */
	public TipoUsuarioDto editar(TipoUsuarioDto tipoUsuario) throws Exception;
}
