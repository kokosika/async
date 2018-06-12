package com.gp.services.interfaces.aplicacion;

import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.services.interfaces.base.BaseService;

import io.reactivex.Observable;

public interface UsuarioService extends BaseService<UsuarioDto> {

	/**
     * Llama al metodo guardar del repositorio UsuarioRepositorio para persistir los datos
     * de los usuarios en el sistema
     * 
     * @param usuario Objeto de tipo UsuarioDto
     * @return retorna el objecto almacenado en la base de datos.
     */
	public Observable<UsuarioDto> guardar(UsuarioDto usuario);
	
	/**
     * Llama al metodo guardar del repositorio UsuarioRepositorio para persistir los datos
     * de los usuarios en el sistema
     * 
     * @param usuario Objeto de tipo UsuarioDto
     * @return retorna el objecto almacenado en la base de datos.
     */
	public Observable<UsuarioDto> editar(UsuarioDto usuario);
	
	/**
     * Llama al metodo buscarPorId del repositorio UsuarioRepositorio para buscar el objeto
     * a partir del id entregado por parametros
     * 
     * @param id del objeto
     * @return resultado de la consulta como UsuarioDto
     */
	public Observable<UsuarioDto> buscarPorId(Integer id);
	
	/**
     * Llama al metodo buscarPorNombreOrMail del repositorio UsuarioRepositorio para buscar el objeto
     * a partir del id entregado por parametros
     * 
     * @param id del objeto
     * @return resultado de la consulta como UsuarioDto
     */
	public Observable<UsuarioDto> buscarPorNombreOrMail(UsuarioDto usuario);

}
