package com.gp.entidades.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gp.entidades.aplicacion.Usuario;
import com.gp.entidades.base.DomainEntity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entidad encargada de registrar todos los tipos de usuario del sistema.
 *
 * @author Franco Cortez
 * @version 1.0
 * @see com.gp.entidades.base.FechaEstadoEntity
 * @see com.gp.entidades.base.IntegerIdEntity
 * @see com.gp.entidades.base.DomainEntity
 */
@Entity(name = "TBL_TIPO_USUARIO")
public class TipoUsuario extends DomainEntity {
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuario")
	@JsonIgnore
	
	
	private Set<Usuario> usuarios;

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
