package com.gp.repositorios.interfaces.base;

import com.gp.dto.base.IntegerIdDto;

import java.util.List;

/**
 * Interfaces de implementacion para los repostirios como base
 * Esta implementada en la clase
 *
 * @see com.gp.repositorios.implement.base.BaseCrudRepositorioImpl
 *
 * @param <T> to pasado por parametros a la clase
 *
 * @author Franco Cortez
 * @version 1.0
 */
public interface BaseCrudRepositorio<T extends IntegerIdDto> {
    /**
     * Metodo que lista todos los registros de la entidad
     * @return una lista con los registros de la entidad.
     */
    public List<T> buscarTodos();
}
