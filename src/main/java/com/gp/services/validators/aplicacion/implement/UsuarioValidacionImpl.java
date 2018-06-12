package com.gp.services.validators.aplicacion.implement;

import org.springframework.stereotype.Component;

import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.services.validators.aplicacion.interfaces.UsuarioValidacion;
import com.gp.services.validators.base.ValidacionUtil;
import com.gp.services.validators.base.ValidacionUtilMethod;

@Component
public class UsuarioValidacionImpl extends ValidacionUtilMethod implements UsuarioValidacion {
	
	@Override
    public void validate(UsuarioDto usuario) throws Exception{
        StringBuilder errores = new StringBuilder();
        errores.append(ValidacionUtil.notNullString
                .or(ValidacionUtil.notEmptyString)
                .resultadoGenerico(usuario.getUsername()).getFieldNameIfInvalid("El nombre de usuario no puede ser null o estar vacio").orElse(""));
        errores.append(ValidacionUtil.stringBetween(1,50)
                .resultadoGenerico(usuario.getUsername()).getFieldNameIfInvalid("El tamaño del nombre de usuario no puede superar los 50 caracteres").orElse(""));
        
        errores.append(ValidacionUtil.notNullString
                .or(ValidacionUtil.notEmptyString)
                .resultadoGenerico(usuario.getPassword()).getFieldNameIfInvalid("La contraceña no puede ser null o estar vacio").orElse(""));
        errores.append(ValidacionUtil.stringBetween(1,50)
                .resultadoGenerico(usuario.getPassword()).getFieldNameIfInvalid("El tamaño de la contraceña no puede superar los 100 caracteres").orElse(""));
                
        String error = errores.toString();
        if(!error.isEmpty())
            throw new Exception(error);
    }

}
