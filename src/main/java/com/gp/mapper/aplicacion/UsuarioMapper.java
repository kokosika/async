package com.gp.mapper.aplicacion;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.mapper.base.BaseCrudMapper;

@Component
public interface UsuarioMapper extends BaseCrudMapper<UsuarioDto> {
	
	public void buscarPorNombreOrMail(Map<String,Object> params);
}
