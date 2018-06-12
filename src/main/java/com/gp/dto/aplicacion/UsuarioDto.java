package com.gp.dto.aplicacion;

import com.gp.dto.base.FechaEstadoDto;

public class UsuarioDto extends FechaEstadoDto {

	private String email;
	private String name;
	private String password;
	private String username;
	
	public UsuarioDto() {}
	
	public UsuarioDto(String email, String name, String password, String userName) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.username = userName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	
	
	
	
}
