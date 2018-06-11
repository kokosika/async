package com.gp.entidades.aplicacion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gp.entidades.base.FechaEstadoEntity;
import com.gp.entidades.dominio.TipoUsuario;

/**
 * Entidad encargada de registrar todos los usuarios del sistema
 *
 * @author Franco Cortez
 * @version 1.0
 * @see com.gp.entidades.base.FechaEstadoEntity
 * @see com.gp.entidades.base.IntegerIdEntity
 */
@Entity(name = "TBL_USUARIOS")
public class Usuario extends FechaEstadoEntity {

	@Column(length = 50, nullable= false, unique = true)
	private String nombreUsuario;
	@Column(length = 50, nullable = false)
	private String contracena;	
	@JoinColumn(referencedColumnName = "id")
	@ManyToOne(optional = false)
	private TipoUsuario tipoUsuario;
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContracena() {
		return contracena;
	}
	public void setContracena(String contracena) {
		this.contracena = contracena;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
}
