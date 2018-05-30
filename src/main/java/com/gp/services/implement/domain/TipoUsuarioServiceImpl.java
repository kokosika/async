package com.gp.services.implement.domain;

import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.repositorios.interfaces.dominio.TipoUsuarioRepositorio;
import com.gp.services.implement.base.BaseServiceImpl;
import com.gp.services.interfaces.domain.TipoUsuarioService;
import com.gp.services.validators.dominio.interfaces.TipoUsuarioValidacion;
import io.reactivex.Observable;
import org.springframework.stereotype.Service;


@Service
public class TipoUsuarioServiceImpl extends BaseServiceImpl<TipoUsuarioDto> implements TipoUsuarioService {

    private final TipoUsuarioRepositorio tipoUsuarioRepositorio;
    private final TipoUsuarioValidacion tipoUsuarioValidacion;
    public TipoUsuarioServiceImpl(final TipoUsuarioRepositorio tipoUsuarioRepositorio,final TipoUsuarioValidacion tipoUsuarioValidacion) {
        super(tipoUsuarioRepositorio);
        this.tipoUsuarioRepositorio = tipoUsuarioRepositorio;
        this.tipoUsuarioValidacion = tipoUsuarioValidacion;
    }

    public Observable<TipoUsuarioDto> guardar(TipoUsuarioDto tipoUsuario) {
        return Observable.create(source -> {
            try {
                this.tipoUsuarioValidacion.validate(tipoUsuario);
                this.tipoUsuarioRepositorio.guardar(tipoUsuario);
                source.onNext(tipoUsuario);
                source.onComplete();
            } catch (Exception ex) {
                source.onError(ex);
            }
        });
    }
}
