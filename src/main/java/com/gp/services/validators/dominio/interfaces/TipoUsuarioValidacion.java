package com.gp.services.validators.dominio.interfaces;

import com.gp.dto.dominio.TipoUsuarioDto;

public interface TipoUsuarioValidacion {

    public void validate(TipoUsuarioDto tipoUsuario) throws Exception;
}
