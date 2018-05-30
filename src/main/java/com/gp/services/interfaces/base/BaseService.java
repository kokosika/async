package com.gp.services.interfaces.base;

import com.gp.dto.base.IntegerIdDto;
import io.reactivex.Observable;

import java.util.List;

/**
 * Interfaz generica de todas las clases de tipo servicio.
 *
 * @param <T>
 */
public interface BaseService<T extends IntegerIdDto> {

    public Observable<List<T>> buscarTodos();
}
