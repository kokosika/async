package com.gp.services.implement.domain;

import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.repositorios.interfaces.dominio.TipoUsuarioRepositorio;
import com.gp.services.implement.base.BaseServiceImpl;
import com.gp.services.interfaces.domain.TipoUsuarioService;
import com.gp.services.validators.dominio.interfaces.TipoUsuarioValidacion;
import io.reactivex.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Clase que contendra la implementacion del repositorio TipoUsuarioService
 * Contendra toda la logica necesaria para realizar operaciones complejas del negocio.
 * Valida los datos que son ingresados por paramtros.
 * 
 * @author Franco Cortez
 * @version 1.0
 *
 */
@Service
public class TipoUsuarioServiceImpl extends BaseServiceImpl<TipoUsuarioDto> implements TipoUsuarioService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TipoUsuarioServiceImpl.class);
	/**
	 * Injeccion del repositorio TipoUsuarioRepositorio
	 */
    private final TipoUsuarioRepositorio tipoUsuarioRepositorio;
    /**
     * Injeccion de las validaciones TipoUsuarioValidacion
     */
    private final TipoUsuarioValidacion tipoUsuarioValidacion;
    
    /**
     * Constructor que inicializa TipoUsuarioServiceImpl con injeccion de dependencias
     * @param tipoUsuarioRepositorio tipo repositorio
     * @param tipoUsuarioValidacion tipo validacion
     */
    public TipoUsuarioServiceImpl(final TipoUsuarioRepositorio tipoUsuarioRepositorio,final TipoUsuarioValidacion tipoUsuarioValidacion) {
        super(tipoUsuarioRepositorio);
        LOGGER.info("Injección de dependencias de la clase.");
        this.tipoUsuarioRepositorio = tipoUsuarioRepositorio;
        this.tipoUsuarioValidacion = tipoUsuarioValidacion;
    }

    /**
     * Llama al metodo guardar del repositorio TipoUsuarioRepositorio para persistir los datos
     * de tipos de usuarios en el sistema
     * 
     * @param tipoUsuario Objecto de tipo TipoUsuarioDto
     * @return retorna el objecto almacenado en la base de datos.
     */
    public Observable<TipoUsuarioDto> guardar(TipoUsuarioDto tipoUsuario) {
    	LOGGER.info("[guardar] = PRE-OBSERVABLE ");
        return Observable.create(source -> {
            try {            	
            	LOGGER.info("[guardar] = BEGIN ");         	
                this.tipoUsuarioValidacion.validate(tipoUsuario);
                this.tipoUsuarioRepositorio.guardar(tipoUsuario);
                source.onNext(tipoUsuario);
                source.onComplete();
                LOGGER.info("[guardar] = END ");
            } catch (Exception ex) {
            	LOGGER.info("[guardar] = ERROR : " + ex.getMessage());
                source.onError(ex);
            }
        });
    }
    
    /**
     * Llama al metodo buscarPorId del repositorio TipoUsuarioRepositorio para buscar el objeto
     * a partir del id entregado por parametros
     * 
     * @param id del objeto
     * @return resultado de la consulta como TipoUsuarioDto
     */
    public Observable<TipoUsuarioDto> buscarPorId (Integer id){
    	LOGGER.info("[buscarPorId] = PRE-OBSERVABLE ");
    	return Observable.create(source -> {
    		try {
    			LOGGER.info("[buscarPorId] = PAUSE ");
    			Thread.sleep(10000);
    			LOGGER.info("[buscarPorId] = IN : id = " + id);
    			if(id == null) {
    				LOGGER.info("[buscarPorId] = IN : id = null ");
    				throw new Exception("El parametro id no puede ser null");
    			}				
				source.onNext(this.tipoUsuarioRepositorio.buscarPorId(id));
				source.onComplete();
				LOGGER.info("[buscarPorId] = END ");
			} catch (Exception ex) {
				LOGGER.info("[buscarPorId] = ERROR : " + ex.getMessage());
				source.onError(ex);
			}
    	});
    }
    
    /**
     * Llama al metodo editar del repositorio TipoUsuarioRepositorio para editar los datos
     * de tipos de usuarios en el sistema
     * 
     * @param tipoUsuario Objecto de tipo TipoUsuarioDto
     * @return retorna el objecto editado en la base de datos.
     */
    public Observable<TipoUsuarioDto> editar(TipoUsuarioDto tipoUsuario) {
    	LOGGER.info("[editar] = PRE-OBSERVABLE ");
        return Observable.create(source -> {
            try {
            	LOGGER.info("[editar] = BEGIN ");
            	if(tipoUsuario.getId() == null) {
            		LOGGER.info("[editar] = IN = id null" );
            		throw new Exception("El id no puede ser null");
            	}
                this.tipoUsuarioValidacion.validate(tipoUsuario);                
                source.onNext(this.tipoUsuarioRepositorio.editar(tipoUsuario));
                source.onComplete();                
                LOGGER.info("[editar] = END ");
            } catch (Exception ex) {
            	LOGGER.info("[editar] = ERROR : " + ex.getMessage());
                source.onError(ex);
            }
        });
    }
}
