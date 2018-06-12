package com.gp.entidades.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.NaturalId;

import com.gp.entidades.base.FechaEstadoEntity;
import com.gp.entidades.enumes.NombreRoles;

/**
 * Entidad encargada de registrar todos los tipos de usuario del sistema.
 *
 * @author Franco Cortez
 * @version 1.0
 * @see com.gp.entidades.base.FechaEstadoEntity
 * @see com.gp.entidades.base.IntegerIdEntity
 */
@Entity(name = "TBL_TIPO_USUARIO")
public class TipoUsuario extends FechaEstadoEntity {
	
	@Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private NombreRoles nombre;
	@Column(length = 100)
	private String descripcion;

	public NombreRoles getNombre() {
		return nombre;
	}

	public void setNombre(NombreRoles nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
