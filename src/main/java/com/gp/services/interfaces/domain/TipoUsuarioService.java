package com.gp.services.interfaces.domain;

import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.services.interfaces.base.BaseService;
import io.reactivex.Observable;

public interface TipoUsuarioService extends BaseService<TipoUsuarioDto> {
	/**
     * Llama al metodo guardar del repositorio TipoUsuarioRepositorio para persistir los datos
     * de tipos de usuarios en el sistema
     * 
     * @param tipoUsuario Objecto de tipo TipoUsuarioDto
     * @return retorna el objecto almacenado en la base de datos.
     */
    public Observable<TipoUsuarioDto> guardar(TipoUsuarioDto tipoUsuario);
    
    /**
     * Llama al metodo buscarPorId del repositorio TipoUsuarioRepositorio para buscar el objeto
     * a partir del id entregado por parametros
     * 
     * @param id del objeto
     * @return resultado de la consulta como TipoUsuarioDto
     */
    public Observable<TipoUsuarioDto> buscarPorId (Integer id);
    
    /**
     * Llama al metodo editar del repositorio TipoUsuarioRepositorio para editar los datos
     * de tipos de usuarios en el sistema
     * 
     * @param tipoUsuario Objecto de tipo TipoUsuarioDto
     * @return retorna el objecto editado en la base de datos.
     */
    public Observable<TipoUsuarioDto> editar(TipoUsuarioDto tipoUsuario);
}
