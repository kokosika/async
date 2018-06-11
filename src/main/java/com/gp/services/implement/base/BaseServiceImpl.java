package com.gp.services.implement.base;

import com.gp.dto.base.IntegerIdDto;
import com.gp.repositorios.interfaces.base.BaseCrudRepositorio;
import com.gp.services.interfaces.base.BaseService;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Base de la implementacion de los servicios.
 * Heredaran todos los servicios de esta clase para obtener funciones genericas
 * @param <T> To pasado por parametro de la clase
 *
 * @see com.gp.services.interfaces.base.BaseService
 *
 * @author Franco Cortez
 * @version 1.0
 */
public class BaseServiceImpl<T extends IntegerIdDto> implements BaseService<T> {

    /**
     * Logger
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

    /**
     * Repositorio base
     */
    private BaseCrudRepositorio<T> baseCrudRepositorio;

    /**
     * Injeccion de dependencias
     * @param baseCrudRepositorio injeccion de BaseCrudRepositorio
     */
    public BaseServiceImpl(BaseCrudRepositorio<T> baseCrudRepositorio) {
        this.baseCrudRepositorio = baseCrudRepositorio;
    }

    /**
     * Metodo asincrono que retorna un Observable para su manipulacion
     * en la capa de salida como web service.
     * @return retorna una respuesta al cliente.
     */
    @SuppressWarnings("all")
    @Transactional(readOnly = true)
    public Observable<List<T>> buscarTodos() {
        return Observable.create(source -> {
            try {
            	LOGGER.info("BaseServiceImpl: BEGIN");
                final List<T> lista = this.baseCrudRepositorio.buscarTodos();
                source.onNext(lista);
                source.onComplete();
                LOGGER.info("BaseServiceImpl: END");
            } catch (Exception ex) {
            	LOGGER.info("BaseServiceImpl: ERROR= " + ex.getMessage());
                source.onError(ex);
            }
        });
    }

    
}
