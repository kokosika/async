package com.gp.services.validators.dominio.implement;

import com.gp.dto.dominio.TipoUsuarioDto;
import com.gp.services.validators.base.ValidacionUtilMethod;
import com.gp.services.validators.dominio.interfaces.TipoUsuarioValidacion;
import com.gp.services.validators.base.ValidacionUtil;
import org.springframework.stereotype.Component;

@Component
public class TipoUsuarioValidacionImpl extends ValidacionUtilMethod implements TipoUsuarioValidacion {
    @Override
    public void validate(TipoUsuarioDto tipoUsuario) throws Exception{
        StringBuilder errores = new StringBuilder();
        errores.append(ValidacionUtil.notNullString
                .or(ValidacionUtil.notEmptyString)
                .resultadoGenerico(tipoUsuario.getNombre()).getFieldNameIfInvalid("El nombre no puede ser null o estar vacio").orElse(""));
        errores.append(ValidacionUtil.stringBetween(1,50)
                .resultadoGenerico(tipoUsuario.getNombre()).getFieldNameIfInvalid("El tamaño del nombre no puede superar los 50 caracteres").orElse(""));
        errores.append(ValidacionUtil.stringBetween(0,100)
                .resultadoGenerico(tipoUsuario.getDescripcion()).getFieldNameIfInvalid("El tamaño de la descripcion no puede ser mayor a 100 caracteres").orElse(""));
        String error = errores.toString();
        if(!error.isEmpty())
            throw new Exception(error);
    }
}
