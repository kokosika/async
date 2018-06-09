package com.gp.repositorios.implement.base;

import com.gp.dto.base.IntegerIdDto;
import com.gp.mapper.base.BaseCrudMapper;
import com.gp.repositorios.interfaces.base.BaseCrudRepositorio;
import org.springframework.data.repository.NoRepositoryBean;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base para los repositorios con metodos base para su implementacion.
 * Implementa la interfaz BaseCrudRepositorio que ayudara a la implementacion de las
 * sub clases
 *
 * @see com.gp.repositorios.interfaces.base.BaseCrudRepositorio
 *
 * @param <T> to pasado por parametros de la clase
 *
 * @author Franco Cortez
 * @version 1.0
 */
@NoRepositoryBean
public class BaseCrudRepositorioImpl<T extends IntegerIdDto> implements BaseCrudRepositorio<T> {

    /**
     * Injeccion de la base del mapper
     */
    private final BaseCrudMapper<T> baseCrudMapper;

    /**
     * Crea una instancia de BaseCrudRepositorioImpl
     * Injectara al BaseCrudMapper
     * @param baseCrudMapper type mapper
     */
    public BaseCrudRepositorioImpl(final BaseCrudMapper<T> baseCrudMapper) {
        this.baseCrudMapper = baseCrudMapper;
    }

    /**
     * Metodo que lista todos los registros de la entidad
     * @return una lista con los registros de la entidad.
     */
    @SuppressWarnings("all")
    @Override
    public List<T> buscarTodos() {
        Map<String, Object> params = new HashMap<>();
        ResultSet rs = null;
        params.put("DATA", rs);
        baseCrudMapper.buscarTodos(params);
        return (List<T>) params.get("DATA");
    }
}
