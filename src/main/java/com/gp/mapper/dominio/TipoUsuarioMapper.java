package com.gp.mapper.dominio;

import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.mapper.base.BaseCrudMapper;
import org.springframework.stereotype.Component;

/**
 * Mapper para los tipos de usuarios.
 * Creara todos los beans para la llamada de procedimientos almacenados
 * desde el xml del tipo de usuario de mybatis
 *
 * @see com.gp.mapper.base.BaseCrudMapper
 *
 * @author Franco Cortez
 * @version 1.0
 */
@Component
public interface TipoUsuarioMapper extends BaseCrudMapper<TipoUsuarioDto> {

}
