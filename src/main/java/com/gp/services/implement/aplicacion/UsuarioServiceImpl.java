package com.gp.services.implement.aplicacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.repositorios.interfaces.aplicacion.UsuarioRepositorio;
import com.gp.services.implement.base.BaseServiceImpl;
import com.gp.services.interfaces.aplicacion.UsuarioService;
import com.gp.services.validators.aplicacion.interfaces.UsuarioValidacion;

import io.reactivex.Observable;

/**
 * Clase que contendra la implementacion del repositorio UsuarioRepositorio
 * Contendra toda la logica necesaria para realizar operaciones complejas del negocio.
 * Valida los datos que son ingresados por parametros.
 * 
 * @author Franco Cortez
 * @version 1.0
 *
 */
@Service
public class UsuarioServiceImpl extends BaseServiceImpl<UsuarioDto> implements UsuarioService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	/**
	 * Injeccion del repositorio UsuarioRepositorio
	 */	
	private final UsuarioRepositorio usuarioRepositorio;
	
	/**
     * Injeccion de las validaciones TipoUsuarioValidacion
     */
    private final UsuarioValidacion usuarioValidacion;

	/**
     * Constructor que inicializa UsuarioServiceImpl con injeccion de dependencias
     * @param usuarioRepositorio tipo repositorio
     * @param usuarioValidacion tipo validacion
     */
	public UsuarioServiceImpl(final UsuarioRepositorio usuarioRepositorio, final UsuarioValidacion usuarioValidacion) {
		super(usuarioRepositorio);
		this.usuarioRepositorio = usuarioRepositorio;
		this.usuarioValidacion = usuarioValidacion;
	}
	
	/**
     * Llama al metodo guardar del repositorio UsuarioRepositorio para persistir los datos
     * de los usuarios en el sistema
     * 
     * @param usuario Objeto de tipo UsuarioDto
     * @return retorna el objecto almacenado en la base de datos.
     */
	public Observable<UsuarioDto> guardar(UsuarioDto usuario){
		LOGGER.info("[guardar] = PRE-OBSERVABLE ");
		return Observable.create(source -> {
			try {
				LOGGER.info("[guardar] = BEGIN");
				this.usuarioValidacion.validate(usuario);
				source.onNext(this.usuarioRepositorio.guardar(usuario).get());
				source.onComplete();
				LOGGER.info("[guardar] = END");
			} catch (Exception e) {
				LOGGER.info("[guardar] = THROW = " + e.getMessage() );
				source.onError(e);
			}			
		});
	}
	
	/**
     * Llama al metodo guardar del repositorio UsuarioRepositorio para persistir los datos
     * de los usuarios en el sistema
     * 
     * @param usuario Objeto de tipo UsuarioDto
     * @return retorna el objecto almacenado en la base de datos.
     */
	public Observable<UsuarioDto> editar(UsuarioDto usuario){
		LOGGER.info("[editar] = PRE-OBSERVABLE ");
		return Observable.create(source -> {
			try {
				LOGGER.info("[editar] = BEGIN");
				if(usuario.getId() == null) {
            		LOGGER.info("[editar] = IN = id null" );
            		throw new Exception("El id no puede ser null");
            	}
				this.usuarioValidacion.validate(usuario);
				source.onNext(this.usuarioRepositorio.editar(usuario).get());
				source.onComplete();
				LOGGER.info("[editar] = END");
			} catch (Exception e) {
				LOGGER.info("[editar] = THROW = " + e.getMessage() );
				source.onError(e);
			}			
		});
	}
	
	/**
     * Llama al metodo buscarPorId del repositorio UsuarioRepositorio para buscar el objeto
     * a partir del id entregado por parametros
     * 
     * @param id del objeto
     * @return resultado de la consulta como UsuarioDto
     */
	public Observable<UsuarioDto> buscarPorId(Integer id){
		LOGGER.info("[buscarPorId] = PRE-OBSERVABLE ");
		return Observable.create(source -> {
			try {
				LOGGER.info("[buscarPorId] = BEGIN");
				LOGGER.info("[buscarPorId] = IN : id = " + id);
				if(id == null) {
	        		LOGGER.info("[editar] = IN = id null" );
	        		throw new Exception("El id no puede ser null");
	        	}
				source.onNext(this.usuarioRepositorio.buscarPorId(id).get());
				source.onComplete();
				LOGGER.info("[buscarPorId] = END ");
			} catch (Exception e) {
				LOGGER.info("[buscarPorId] = THROW = " + e.getMessage() );
				source.onError(e);
			}
		});
	}
	
	/**
     * Llama al metodo buscarPorNombreOrMail del repositorio UsuarioRepositorio para buscar el objeto
     * a partir del id entregado por parametros
     * 
     * @param id del objeto
     * @return resultado de la consulta como UsuarioDto
     */
	public Observable<UsuarioDto> buscarPorNombreOrMail(UsuarioDto usuario){
		LOGGER.info("[buscarPorNombreOrMail] = PRE-OBSERVABLE ");
		return Observable.create(source -> {
			try {
				LOGGER.info("[buscarPorNombreOrMail] = BEGIN");
				if(usuario.getEmail() == null || usuario.getUsername() == null) {
					LOGGER.info("[editar] = IN = el nombre de usuario o el mail es null" );
	        		throw new Exception("El mail o el nombre de usuario deben tener un valor");
				}
				source.onNext(this.usuarioRepositorio.buscarPorNombreOrMail(usuario).get());
				source.onComplete();
				LOGGER.info("[buscarPorNombreOrMail] = END ");
			} catch (Exception e) {
				LOGGER.info("[buscarPorNombreOrMail] = THROW = " + e.getMessage() );
				source.onError(e);
			}
		});
	}

}
