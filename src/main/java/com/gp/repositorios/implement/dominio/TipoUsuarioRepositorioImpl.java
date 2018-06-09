package com.gp.repositorios.implement.dominio;

import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.mapper.dominio.TipoUsuarioMapper;
import com.gp.repositorios.implement.base.BaseCrudRepositorioImpl;
import com.gp.repositorios.interfaces.dominio.TipoUsuarioRepositorio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoUsuarioRepositorioImpl.class);
	
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
	 * Guarda uno tipo de usuario en la base de datos
	 * 
	 * @param tipoUsuario objeto de tipo de usuario que se desea persistir
	 * @return retorna el objecto.
	 * @throws Exception
	 */
    public TipoUsuarioDto guardar(TipoUsuarioDto tipoUsuario) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("nombre", tipoUsuario.getNombre());
        params.put("descripcion", tipoUsuario.getDescripcion());
        tipoUsuarioMapper.guardar(params);
        return tipoUsuario;
    }
    
    /**
     * Buscar en la base de datos un tipo de usuario a travez de su id
     * 
     * @param id del registro
     * @return el registro como tipo de usuario
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public TipoUsuarioDto buscarPorId(Integer id) throws Exception {
    	 LOGGER.info("[buscarPorId] = BEGIN");
    	 Map<String, Object> params = new HashMap<>();
         ResultSet rs = null;
         params.put("V_ID", id);
         params.put("DATA", rs);
         LOGGER.info("[buscarPorId] Ejecucion del mapper");
         tipoUsuarioMapper.buscarPorId(params);
         List<TipoUsuarioDto> result = (List<TipoUsuarioDto>) params.get("DATA");
         if(result.isEmpty()){
        	 LOGGER.info("[buscarPorId] = THROW : Registro no Encontrado ");
        	 throw new Exception("El registro no fue encontrado");
         }
         LOGGER.info("[buscarPorId] = END");
         
         return result.get(0);
    }
    
    /**
     * Edita un registro dentro de la base de datos.
     * @param tipoUsuarioDto
     * @return
     */
    @SuppressWarnings("unchecked")
	public TipoUsuarioDto editar(TipoUsuarioDto tipoUsuario) throws Exception {
    	 LOGGER.info("[editar] = BEGIN");
    	 Map<String, Object> params = new HashMap<>();
    	 ResultSet rs = null;
    	 params.put("V_ID", tipoUsuario.getId());
         params.put("V_NOMBRE", tipoUsuario.getNombre());
         params.put("V_DESCRIPCION", tipoUsuario.getDescripcion());
         params.put("DATA", rs);
         tipoUsuarioMapper.editar(params);
         List<TipoUsuarioDto> result = (List<TipoUsuarioDto>) params.get("DATA");
         if(result.isEmpty()){
        	 LOGGER.info("[editar] = ERROR = El registro no fue encontrado");
        	 throw new Exception("El registro no fue encontrado");
         }
         LOGGER.info("[editar] = END");         
         return result.get(0);
    }
}
