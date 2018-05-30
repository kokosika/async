package com.gp.repositorios.implement.dominio;

import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.mapper.dominio.TipoUsuarioMapper;
import com.gp.repositorios.implement.base.BaseCrudRepositorioImpl;
import com.gp.repositorios.interfaces.dominio.TipoUsuarioRepositorio;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementacion del repositorio de tipos de usuarios.
 * Hereda de la clase BaseCrudRepositorioImpl donde se le pasa como parametro de tipo TipoUsuarioDto
 *
 * Implementa la interfaz TipoUsuarioRepositorio para realizar la injeccion de dependecias en la capa de servicios.
 *
 * @see com.gp.repositorios.implement.base.BaseCrudRepositorioImpl
 * @see com.gp.repositorios.interfaces.dominio.TipoUsuarioRepositorio
 * @see TipoUsuarioDto
 *
 * @author Franco Cortez
 * @version 1.0
 */
@Repository
@EnableAutoConfiguration
@Transactional
public class TipoUsuarioRepositorioImpl extends BaseCrudRepositorioImpl<TipoUsuarioDto> implements TipoUsuarioRepositorio {

    /**
     * Injeccion del mapper tipos de usuario
     */
    private final TipoUsuarioMapper tipoUsuarioMapper;

    /**
     * Injeccion del mapper tipo de usuario
     *
     * @param tipoUsuarioMapper mapper
     */
    public TipoUsuarioRepositorioImpl(final TipoUsuarioMapper tipoUsuarioMapper) {
        super(tipoUsuarioMapper);
        this.tipoUsuarioMapper = tipoUsuarioMapper;
    }

    /**
     * Guarda un tipo de usuario en la base de datos
     * @param tipoUsuario objecto para guardar en la base de datos
     * @return retorna la entidad guardada
     */
    public TipoUsuarioDto guardar(TipoUsuarioDto tipoUsuario) {
        Map<String, Object> params = new HashMap<>();
        params.put("nombre", tipoUsuario.getNombre());
        params.put("descripcion", tipoUsuario.getDescripcion());
        tipoUsuarioMapper.guardar(params);
        return tipoUsuario;
    }
}
