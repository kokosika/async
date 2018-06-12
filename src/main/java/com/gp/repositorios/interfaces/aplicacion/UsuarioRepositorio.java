package com.gp.repositorios.interfaces.aplicacion;

import java.util.Optional;

import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.repositorios.interfaces.base.BaseCrudRepositorio;

public interface UsuarioRepositorio extends BaseCrudRepositorio<UsuarioDto> {
	
	/**
	 * Guarda un usuario en la base de datos
	 * 
	 * @param usuario objeto de usuario que se desea persistir
	 * @return retorna el objecto.
	 * @throws Exception
	 */
	public Optional<UsuarioDto> guardar(UsuarioDto usuario) throws Exception;
    
    /**
     * Buscar en la base de datos un usuario a travez de su id.
     * 
     * @param id del registro.
     * @return el registro como usuario.
     * @throws Exception.
     */
	public Optional<UsuarioDto> buscarPorId(Integer id) throws Exception;
    
    /**
     * Edita un registro dentro de la base de datos. 
     * @param usuario objeto de tipo usuario que se desea editar
     * @return el objeto con los cambios.
     * @throws Exception
     */
	public Optional<UsuarioDto>  editar(UsuarioDto usuario) throws Exception;
	
	/**
     * Metodo que busca a un usuario en la base de datos por medio de su nombre de usuario o
     * su correo.
     * 
     * @param usuario usuario que se desea buscar
     * @return retorna un opcional de usuario
     * @throws Exception excepcion lanzada por si ocurre algun problema.
     */
    public Optional<UsuarioDto> buscarPorNombreOrMail(UsuarioDto usuario) throws Exception;

}
