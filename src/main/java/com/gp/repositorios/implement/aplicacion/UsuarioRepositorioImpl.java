package com.gp.repositorios.implement.aplicacion;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.mapper.aplicacion.UsuarioMapper;
import com.gp.repositorios.implement.base.BaseCrudRepositorioImpl;
import com.gp.repositorios.interfaces.aplicacion.UsuarioRepositorio;

/**
 * Implementacion del repositorio de usuarios.
 * Hereda de la clase BaseCrudRepositorioImpl donde se le pasa como parametro de tipo UsuarioDto
 *
 * Implementa la interfaz UsuarioRepositorio para realizar la injeccion de dependecias en la capa de servicios.
 *
 * @see com.gp.repositorios.implement.base.BaseCrudRepositorioImpl
 * @see com.gp.repositorios.interfaces.dominio.TipoUsuarioRepositorio
 * @see UsuarioDto
 *
 * @author Franco Cortez
 * @version 1.0
 */
@Repository
@EnableAutoConfiguration
@Transactional
public class UsuarioRepositorioImpl extends BaseCrudRepositorioImpl<UsuarioDto> implements UsuarioRepositorio {
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepositorioImpl.class);
	
	/**
     * Injeccion del mapper de usuario
     */
	private final UsuarioMapper usuarioMapper;
	
	/**
     * Injeccion del mapper usuario
     *
     * @param usuarioMapper mapper
     */
	public UsuarioRepositorioImpl(final UsuarioMapper usuarioMapper) {
		super(usuarioMapper);
		this.usuarioMapper = usuarioMapper;
	}

	/**
	 * Guarda un usuario en la base de datos
	 * 
	 * @param usuario objeto de usuario que se desea persistir
	 * @return retorna el objecto.
	 * @throws Exception
	 */
    @SuppressWarnings("unchecked")
	public Optional<UsuarioDto> guardar(UsuarioDto usuario) throws Exception {
    	LOGGER.info("[guardar] = BEGIN");
        Map<String, Object> params = new HashMap<>();
        ResultSet rs = null;
        params.put("V_CORREO",usuario.getEmail());
        params.put("V_CONTRACENA",usuario.getPassword());
        params.put("V_NOMBRE",usuario.getName());
        params.put("V_NOMBRE_USUARIO",usuario.getUsername());        
        params.put("DATA", rs);
        LOGGER.info("[guardar] = EJECUCION: guardar del mapper");
        usuarioMapper.guardar(params);
        LOGGER.info("[guardar] = Extracion de los datos");
        List<UsuarioDto> result = (List<UsuarioDto>) params.get("DATA");
        if(result.isEmpty()){
        	LOGGER.info("[guardar] = THROW : Registro no se pudo guardar ");
       	 	throw new Exception("El registro no fue almacenado");
        }
        Optional<UsuarioDto> option = Optional.of(result.get(0));
        LOGGER.info("[guardar] = END");
        return option;
    }
    
    /**
     * Buscar en la base de datos un usuario a travez de su id.
     * 
     * @param id del registro.
     * @return el registro como usuario.
     * @throws Exception.
     */
    @SuppressWarnings("unchecked")
	public Optional<UsuarioDto> buscarPorId(Integer id) throws Exception {
    	 LOGGER.info("[buscarPorId] = BEGIN");
    	 Map<String, Object> params = new HashMap<>();
         ResultSet rs = null;
         params.put("V_ID", id);         
         params.put("DATA", rs);
         LOGGER.info("[buscarPorId] Ejecucion del mapper");
         usuarioMapper.buscarPorId(params);
         List<UsuarioDto> result = (List<UsuarioDto>) params.get("DATA");
         if(result.isEmpty()){
        	 LOGGER.info("[buscarPorId] = THROW : Registro no Encontrado ");
        	 throw new Exception("El registro no fue encontrado");
         }
         LOGGER.info("[buscarPorId] = END");   
         Optional<UsuarioDto> opcion = Optional.of(result.get(0));
         return opcion;
    }
    
    /**
     * Metodo que busca a un usuario en la base de datos por medio de su nombre de usuario o
     * su correo.
     * 
     * @param usuario usuario que se desea buscar
     * @return retorna un opcional de usuario
     * @throws Exception excepcion lanzada por si ocurre algun problema.
     */
    @SuppressWarnings("unchecked")
    public Optional<UsuarioDto> buscarPorNombreOrMail(UsuarioDto usuario) throws Exception{
    	LOGGER.info("[buscarPorNombreOrMail] = BEGIN");
    	Map<String, Object> params = new HashMap<>();
        ResultSet rs = null;
        params.put("V_NOMBRE_USUARIO", usuario.getUsername()); 
        params.put("V_CORREO", usuario.getEmail());   
        params.put("DATA", rs);
        LOGGER.info("[buscarPorNombreOrMail] Ejecucion del mapper");
        usuarioMapper.buscarPorNombreOrMail(params);
        List<UsuarioDto> result = (List<UsuarioDto>) params.get("DATA");
        if(result.isEmpty()){
       	 LOGGER.info("[buscarPorNombreOrMail] = THROW : Registro no Encontrado ");
       	 	throw new Exception("El registro no fue encontrado");
        }
        Optional<UsuarioDto> opcion = Optional.of(result.get(0));
        LOGGER.info("[buscarPorNombreOrMail] = END");   
        return opcion;
    }
    
    /**
     * Edita un registro dentro de la base de datos. 
     * @param usuario objeto de tipo usuario que se desea editar
     * @return el objeto con los cambios.
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public Optional<UsuarioDto> editar(UsuarioDto usuario) throws Exception {
    	 LOGGER.info("[editar] = BEGIN");
    	 Map<String, Object> params = new HashMap<>();
    	 ResultSet rs = null;
    	 params.put("V_ID",usuario.getId());
    	 params.put("V_CORREO",usuario.getEmail());
         params.put("V_CONTRACENA",usuario.getPassword());
         params.put("V_NOMBRE",usuario.getName());
         params.put("V_NOMBRE_USUARIO",usuario.getUsername());     
         params.put("DATA", rs);
         LOGGER.info("[editar] = EJECUCION: editar del mapper");
         usuarioMapper.editar(params);
         LOGGER.info("[editar] = Obtener los datos.");
         List<UsuarioDto> result = (List<UsuarioDto>) params.get("DATA");
         if(result.isEmpty()){
        	 LOGGER.info("[editar] = ERROR = El registro no fue encontrado");
        	 throw new Exception("El registro no fue encontrado");
         }
         Optional<UsuarioDto> option = Optional.of(result.get(0));
         LOGGER.info("[editar] = END");         
         return option;
    }
	
}
