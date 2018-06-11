package com.gp.dto.aplicacion;

import com.gp.dto.base.FechaEstadoDto;

public class UsuarioDto extends FechaEstadoDto {

	private String nombreUsuario;
	private String contracena;
	private Integer tipoUsuarioId;
	private String tipoUsuarioNombre;
	
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
	public Integer getTipoUsuarioId() {
		return tipoUsuarioId;
	}
	public void setTipoUsuarioId(Integer tipoUsuarioId) {
		this.tipoUsuarioId = tipoUsuarioId;
	}
	public String getTipoUsuarioNombre() {
		return tipoUsuarioNombre;
	}
	public void setTipoUsuarioNombre(String tipoUsuarioNombre) {
		this.tipoUsuarioNombre = tipoUsuarioNombre;
	}
	
	
	
}
