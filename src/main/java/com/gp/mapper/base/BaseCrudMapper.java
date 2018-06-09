package com.gp.mapper.base;

import com.gp.dto.base.IntegerIdDto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Base generica con las acciones de crud del sistema
 * Mapper necesario para el funcionamiento de mybatis
 * Ayudara a las acciones del xml tipoUsuario
 *
 *
 * @param <T> to pasado por parametros que extiende de IntegerIdDto
 * @see IntegerIdDto
 *
 * @author Franco Cortez
 * @version 1.0
 */
@Repository
@EnableAutoConfiguration
public interface BaseCrudMapper<T extends IntegerIdDto> {

    /**
     * Buscar todos los registros del to pasado por parametro.
     * @param params parametros requeridos para la funcionalidad
     * @return retorna los registros en tipo lista de la entidad
     */
    public List<T> buscarTodos(Map<String, Object> params);

    /**
     * Busca los registros de la entidad por medio de id del to
     * @param params parametros requeridos para la funcionalidad
     * @return retorna el registro encontrado por el procedimiento.
     */
    public T buscarPorId(Map<String, Object> params);

    /**
     * Guarda la entidad en la base de datos que se le pasara por parametros
     * @param params parametros requeridos para la funcionalidad
     */
    public void guardar(Map<String, Object> params);

    /**
     * Edita la entidad en la base de datos que se le pasara por parametros
     * @param params parametros requeridos para la funcionalidad
     */
    public void editar(Map<String, Object> params);

    /**
     * Elimina la entidad que se pasara por parametros.
     * @param params parametros necesarios para la funcionalidad .
     */
    public void eliminar(Map<String, Object> params);

}
