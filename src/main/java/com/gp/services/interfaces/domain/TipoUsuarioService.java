package com.gp.services.interfaces.domain;

import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.services.interfaces.base.BaseService;
import io.reactivex.Observable;

public interface TipoUsuarioService extends BaseService<TipoUsuarioDto> {
    public Observable<TipoUsuarioDto> guardar(TipoUsuarioDto tipoUsuario);
}
